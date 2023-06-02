package com.dsm.newtrash.back.springboot.global.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.dsm.newtrash.back.springboot.global.jwt.exception.TokenUnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${auth.jwt.secret}")
    private String secretKey;
    
    private final UserDetailsService userDetailsService;

    public Authentication getAuthentication(String token) {
        UserDetails details = userDetailsService.loadUserByUsername(getUserName(token));
        return new UsernamePasswordAuthenticationToken(details, "", details.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            Claims c = getBody(token);
            getBody(token).getExpiration().after(new Date());
            return true;
        } catch (Exception e) {
            throw TokenUnauthorizedException.EXCEPTION;
        }
    }

    public String getUserName(String token) {
        return getBody(token).getSubject();
    }

    private Claims getBody(String token) {
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
    }

}
