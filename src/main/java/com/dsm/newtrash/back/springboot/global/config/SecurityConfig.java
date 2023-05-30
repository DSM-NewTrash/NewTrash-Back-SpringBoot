package com.dsm.newtrash.back.springboot.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.dsm.newtrash.back.springboot.global.exception.handler.AuthenticationEntryPointImpl;
import com.dsm.newtrash.back.springboot.global.jwt.FilterConfig;
import com.dsm.newtrash.back.springboot.global.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationEntryPointImpl authenticationEntryPoint;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
            .cors().and()
            .formLogin().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .httpBasic().disable()

            .authorizeHttpRequests(request -> request
                .requestMatchers(HttpMethod.POST, "/quizs").authenticated()
                .requestMatchers(HttpMethod.GET, "/quizs/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/quizs/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/quizs/adjustment/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/quizs/review/**").authenticated()
                .anyRequest().permitAll()
            )

            .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
            .and().apply(new FilterConfig(jwtTokenProvider))
            .and().build();
    }

}