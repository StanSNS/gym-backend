package gym.backend.init;

import gym.backend.models.entity.AdminEntity;
import gym.backend.models.entity.RoleEntity;
import gym.backend.repository.AdminEntityRepository;
import gym.backend.repository.RoleEntityRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

import static gym.backend.consts.Auth.RoleConst.ADMIN_C;
import static gym.backend.consts.Auth.RoleConst.USER_C;


@Component
@RequiredArgsConstructor
public class MainDataInit {
    private final AdminEntityRepository adminEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleEntityRepository roleRepository;

    @Value("${admin.auth.login.username}")
    private String ADMIN_AUTH_LOGIN_USERNAME;

    @Value("${admin.auth.login.password}")
    private String ADMIN_AUTH_LOGIN_PASSWORD;

    @PostConstruct
    public void dataInit() {
        if (roleRepository.count() == 0) {
            roleRepository.save(new RoleEntity(ADMIN_C));
            roleRepository.save(new RoleEntity(USER_C));
        }

        if (adminEntityRepository.count() == 0) {
            AdminEntity adminEntity = new AdminEntity();
            adminEntity.setUsername(ADMIN_AUTH_LOGIN_USERNAME);
            adminEntity.setPassword(passwordEncoder.encode(ADMIN_AUTH_LOGIN_PASSWORD));
            adminEntity.setJwtToken(null);

            RoleEntity roleEntity = roleRepository.findByName(ADMIN_C);
            if (roleEntity != null) {
                adminEntity.setRoles(new HashSet<>());
                adminEntity.getRoles().add(roleEntity);
            }

            adminEntityRepository.save(adminEntity);
        }

    }
}





