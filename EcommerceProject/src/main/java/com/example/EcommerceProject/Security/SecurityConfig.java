package com.example.EcommerceProject.Security;
import com.example.EcommerceProject.config.CorsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final CorsConfig corsConfig;

    // 👇 Inject JWT filter
    public SecurityConfig(JwtFilter jwtFilter, CorsConfig corsConfig) {
        this.jwtFilter = jwtFilter;
        this.corsConfig = corsConfig;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {})

                .authorizeHttpRequests(auth -> auth
                        // Public endpoints
                        .requestMatchers("/api/users/register", "/api/users/login").permitAll()

                        // current user profile
                        .requestMatchers(HttpMethod.GET, "/api/users/me").hasAnyRole("USER", "ADMIN")

                        // 👇 Anyone authenticated (USER or ADMIN) can VIEW products
                        .requestMatchers(HttpMethod.GET, "/api/users/products/**").hasAnyRole("USER", "ADMIN")

                        // 👇 Only ADMIN can modify products
                        .requestMatchers(HttpMethod.POST, "/api/users/products/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/users/products/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/products/**").hasRole("ADMIN")
                        .requestMatchers("/api/users/cart/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )

                // 👇 IMPORTANT for JWT (stateless)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // 👇 THIS IS THE KEY LINE
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    // ✅ Needed for login
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}