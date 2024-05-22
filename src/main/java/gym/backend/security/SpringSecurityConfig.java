package gym.backend.security;

import gym.backend.utils.ValidateData;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static gym.backend.consts.Auth.RoleConst.ADMIN_C;
import static gym.backend.consts.Urls.AdminControllerUrlPaths.*;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig implements WebMvcConfigurer {

    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final JwtAuthenticationFilter authenticationFilter;
    private final JwtTokenProvider jwtTokenProvider;
    private final ValidateData validateData;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((authorize) -> {

            authorize.requestMatchers(
                    AUTH_LOGIN
            ).permitAll();

            authorize.requestMatchers(
                    BASE_ADMIN,
                    TASTE_COLOR_EXECUTE,
                    TASTE_DATA_EXECUTE,
                    PRODUCT_DATA_EXECUTE,
                    PRODUCT_DATA_DETAILS_EXECUTE,
                    PRODUCT_DATA_DETAILS_SHEET_EXECUTE,
                    PRODUCT_DATA_DETAILS_WEB_EXECUTE,
                    SPEEDY_OFFICES_EXECUTE,
                    ALL_EXECUTE
            ).authenticated();

            authorize.requestMatchers(
                    BASE_ADMIN,
                    TASTE_COLOR_EXECUTE,
                    TASTE_DATA_EXECUTE,
                    PRODUCT_DATA_EXECUTE,
                    PRODUCT_DATA_DETAILS_EXECUTE,
                    PRODUCT_DATA_DETAILS_SHEET_EXECUTE,
                    PRODUCT_DATA_DETAILS_WEB_EXECUTE,
                    SPEEDY_OFFICES_EXECUTE,
                    ALL_EXECUTE
            ).hasRole(ADMIN_C);

            authorize.anyRequest().authenticated();
        });
        http.httpBasic(Customizer.withDefaults());
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AdminInterceptor adminInterceptor = new AdminInterceptor(jwtTokenProvider, validateData);
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns(BASE_ADMIN + "/*")
                .excludePathPatterns(AUTH_LOGIN);
    }
}
