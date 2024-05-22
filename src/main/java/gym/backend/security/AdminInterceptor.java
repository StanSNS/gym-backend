package gym.backend.security;

import gym.backend.models.entity.AdminEntity;
import gym.backend.security.JwtTokenProvider;
import gym.backend.utils.ValidateData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
@Component
public class AdminInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;
    private final ValidateData validateData;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        String queryString = request.getQueryString();

        if (!queryString.isEmpty()) {
            String[] parts = queryString.split("&");

            String username = parts[1].split("=")[1];
            String jwtToken = parts[2].split("=")[1];

            AdminEntity adminEntity = validateData.validateUserWithJWT(username, jwtToken);

            if (adminEntity != null && validateData.isUserAdmin(adminEntity.getRoles()) && jwtTokenProvider.validateToken(jwtToken)) {
                return true;
            }
        }
        return false;
    }
}