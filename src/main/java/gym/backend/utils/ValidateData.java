package gym.backend.utils;

import gym.backend.exception.AccessDeniedException;
import gym.backend.exception.JwtAuthenticationException;
import gym.backend.exception.ResourceNotFoundException;
import gym.backend.models.entity.AdminEntity;
import gym.backend.models.entity.RoleEntity;
import gym.backend.repository.AdminEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static gym.backend.consts.Auth.RoleConst.ADMIN_C;

@Service
@RequiredArgsConstructor
public class ValidateData {

    private final AdminEntityRepository adminEntityRepository;

    public AdminEntity validateUserWithJWT(String username, String jwtToken) {
        Optional<AdminEntity> adminUserEntityOptional = adminEntityRepository.findByUsername(username);
        if (adminUserEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        AdminEntity admin = adminUserEntityOptional.get();
        if (!admin.getJwtToken().equals(jwtToken)) {
            throw new JwtAuthenticationException();
        }
        return admin;
    }


    public void validateUserAuthority(String username) {
        Optional<AdminEntity> adminEntityOptional = adminEntityRepository.findByUsername(username);
        if (adminEntityOptional.isPresent()) {
            AdminEntity adminEntity = adminEntityOptional.get();
            if (!isUserAdmin(adminEntity.getRoles())) {
                throw new AccessDeniedException();
            }
        }
    }

    public boolean isUserAdmin(Set<RoleEntity> roles) {
        for (RoleEntity role : roles) {
            if (role.getName().equals(ADMIN_C)) {
                return true;
            }
        }
        return false;
    }

}