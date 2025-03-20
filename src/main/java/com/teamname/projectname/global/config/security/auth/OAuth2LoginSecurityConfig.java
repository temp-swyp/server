package com.teamname.projectname.global.config.security.auth;

import com.teamname.projectname.global.config.security.auth.util.JwtUtil;
import javax.crypto.spec.SecretKeySpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity// spring security 설정 활성화
public class OAuth2LoginSecurityConfig {
    private final CustomOauth2UserService customOauth2UserService;
    private final CustomSuccessHandler customSuccessHandler;
    private final JwtUtil jwtUtil;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/", "/favicon.ico", "/css/**", "/images/**", "/js/**","/h2-console/**").permitAll() // 정적 리소스 및 루트 페이지 허용
                .anyRequest().authenticated()// All other requests require authentication
            );

        //spring-boot-starter-oauth2-resource-server 라이브러리 사용
        http.
            oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtUtil.jwtDecoder())));

        //운영시 삭제
        http
            .csrf((auth) -> auth.disable())
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
            .formLogin((auth) -> auth.disable());

        /*
         * userService(customOauth2UserService))
         * Provider()로부터 사용자 정보를 가져와 사용자 정보를 저장하거나 업데이트하는 로직을 구현합니다.
         * successHandler(customSuccessHandler)
         * OAuth 2.0 로그인 성공 후 JWT 토큰을 생성하거나, 리다이렉트하는 로직을 구현합니다.
         */
        http
            .oauth2Login(oauth2 -> oauth2
                .userInfoEndpoint(userInfo -> userInfo
                    .userService(customOauth2UserService))
                .successHandler(customSuccessHandler)
            );


        //세션 설정 : STATELESS
        http
            .sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


}
