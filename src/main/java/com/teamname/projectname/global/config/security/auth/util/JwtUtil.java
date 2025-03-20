package com.teamname.projectname.global.config.security.auth.util;

import com.teamname.projectname.global.config.security.auth.dto.CustomOauth2User;
import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final  SecretKeySpec secretKeySpec;

    public JwtUtil(@Value("${spring.jwt.secret}")String secret) {

        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
        secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
    }

    public String createJwt(CustomOauth2User customOauth2User, long expiredMs) {
        return Jwts.builder()
            .claim("userId", customOauth2User.getUserId())
            .claim("role", customOauth2User.getAuthorities())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + expiredMs))
            .signWith(this.secretKey)
            .compact();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withSecretKey(this.secretKeySpec).build();
    }
}
