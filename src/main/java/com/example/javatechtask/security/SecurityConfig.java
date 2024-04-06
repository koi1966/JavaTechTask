package com.example.javatechtask.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ApiKeySimpleFilter simpleApiKeyAuthFilter;

    @Bean
    SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/report").permitAll()
                        .requestMatchers("/file").permitAll()

                        .anyRequest().authenticated())

                .addFilterAfter(simpleApiKeyAuthFilter, LogoutFilter.class)
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                );


        //    http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
        return http.build();
    }
}
