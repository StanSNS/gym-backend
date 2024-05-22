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

import static gym.backend.consts.Auth.JWTConst.TOKEN_HEADER;

@RequiredArgsConstructor
@Component
public class AdminInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;
    private final ValidateData validateData;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        String header = request.getHeader(TOKEN_HEADER);

        if (!header.isEmpty()) {
            String jwtToken = header.split("\\s+")[1];

            if (jwtTokenProvider.validateToken(jwtToken)) {
                String username = jwtTokenProvider.getUsername(jwtToken);
                validateData.validateUserWithJWT(username, jwtToken);
                validateData.validateUserAuthority(username);
                return true;
            }
        }
        return false;
    }
}