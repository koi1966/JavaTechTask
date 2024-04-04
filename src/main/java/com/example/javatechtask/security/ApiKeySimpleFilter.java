package com.example.javatechtask.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class ApiKeySimpleFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String apiKey = request.getHeader("x-api-key");

//        if (apiKey == null || apiKey.isBlank()) {
//            filterChain.doFilter(request, response);
//            return;
//        }

        if ("valid-key".equals(apiKey) ) {
            log.info("Valid API KEY provided");
            filterChain.doFilter(request, response);
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken("user",null, List.of()));
        } else {

            log.debug("Invalid API KEY provided ");
            throw new BadCredentialsException("Invalid API KEY");
        }


    }
}
