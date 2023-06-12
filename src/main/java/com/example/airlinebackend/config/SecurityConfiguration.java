package com.example.airlinebackend.config;

import com.example.airlinebackend.model.Enum.Role;
import com.example.airlinebackend.repository.ApiKeyRepository;
import com.example.airlinebackend.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    private final ApiKeyFilter apiKeyFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                    .requestMatchers("/api/auth/**").permitAll()
                    .requestMatchers("/api/news/**").permitAll()
                    .requestMatchers("/api/flight/search").permitAll()
                    .requestMatchers("/api/city/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/flight").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/flight").hasAuthority("ADMIN")
                    .requestMatchers("/api/ticket/purchase/external").permitAll()
                    .requestMatchers("/api/ticket/**").hasAuthority("REGISTERED")
                    .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }

//    @Bean
//    public ApiKeyFilter apiKeyFilter() {
//        return new ApiKeyFilter(new ApiKeyService(new ApiKeyRepository()));
//    }
}
