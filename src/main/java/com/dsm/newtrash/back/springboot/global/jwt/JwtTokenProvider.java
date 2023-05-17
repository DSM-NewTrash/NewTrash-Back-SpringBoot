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
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Value("${auth.jwt.exp.refresh}")
    private Long tokenTime;
    
    private final UserDetailsService userDetailsService;

    public String generateToken() {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + tokenTime * 1000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String accessToken) {
        UserDetails details = userDetailsService.loadUserByUsername("");
        return new UsernamePasswordAuthenticationToken(details, "", details.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            return getBody(token).getExpiration().after(new Date());
        } catch (Exception e) {
            throw TokenUnauthorizedException.EXCEPTION;
        }
    }

    private Claims getBody(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

}