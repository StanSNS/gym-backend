package gym.backend.security;

import gym.backend.models.entity.AdminEntity;
import gym.backend.models.entity.RoleEntity;
import gym.backend.repository.AdminEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static gym.backend.consts.Auth.OtherConst.DEFAULT_USER_PASSWORD;
import static gym.backend.consts.Auth.OtherConst.DEFAULT_USER_USERNAME;
import static gym.backend.consts.Auth.RoleConst.ROLE_PREFIX;
import static gym.backend.consts.Auth.RoleConst.USER_C;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminEntityRepository adminEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity admin = adminEntityRepository.findByUsername(username).orElse(null);

        if (admin == null) {
            return createDefaultUser();
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        if (admin.getRoles() != null) {
            for (RoleEntity role : admin.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()));
            }
        }

        return new User(username, admin.getPassword(), authorities);
    }


    public UserDetails createDefaultUser() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + USER_C));
        return new User(DEFAULT_USER_USERNAME, DEFAULT_USER_PASSWORD, authorities);
    }

}