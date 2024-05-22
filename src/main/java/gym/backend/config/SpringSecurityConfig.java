package gym.backend.config;

import gym.backend.security.JwtAuthenticationEntryPoint;
import gym.backend.security.JwtAuthenticationFilter;
import gym.backend.security.JwtTokenProvider;
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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static gym.backend.consts.Auth.RoleConst.ADMIN_C;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig implements WebMvcConfigurer {

    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    private final JwtAuthenticationFilter authenticationFilter;
    private final JwtTokenProvider jwtTokenProvider;
    private final ValidateData validateData;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF protection
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((authorize) -> {
            // Define request matchers and permissions
            authorize.requestMatchers(
                    "/admin/auth/login"

//                    ALL_PATHS,
//                    CUSTOM_LOGOUT_PATHS,
//                    ADMIN_PATH,
//                    AUTH_PATH,
//                    ABOUT_PATH,
//                    PRICING_PATH,
//                    ACCOUNTS_PATH,
//                    PARTNERS_PATH,
//                    COMMUNITY_PATH,
//                    CHANGE_PASSWORD_PATH,
//                    RESET_PASSWORD_PATH,
//                    RESET_PASSWORD_UPDATE_PATH,
//                    TWO_FACTOR_AUTH_CONTROLLER_MAPPING_LOGIN
            ).permitAll();
            authorize.requestMatchers("/admin").authenticated();
            authorize.requestMatchers("/admin").hasRole(ADMIN_C);
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

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AdminInterceptor(jwtTokenProvider, validateData))
//                .addPathPatterns("/admin").addPathPatterns("/community/{action}");
//    }
}
