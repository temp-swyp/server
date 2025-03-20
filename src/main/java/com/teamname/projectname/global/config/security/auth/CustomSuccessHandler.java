package com.teamname.projectname.global.config.security.auth;

import com.teamname.projectname.global.config.security.auth.dto.CustomOauth2User;
import com.teamname.projectname.global.config.security.auth.util.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;

    public CustomSuccessHandler(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {

        // DefaultOAuth2User로 변경
        CustomOauth2User customOauth2User = (CustomOauth2User) authentication.getPrincipal();

        String token = jwtUtil.createJwt(customOauth2User, 60000 );

        // 쿠키 생성 및 redirect 고쳐야할 부분
//        response.addCookie(createCookie("Authorization", token));
        response.setHeader("Authorization", "Bearer " + token);
        response.sendRedirect("http://localhost:3000/");
    }

//    private Cookie createCookie(String key, String value) {
//
//        Cookie cookie = new Cookie(key, value);
//        cookie.setMaxAge(60*60*60);
//        //cookie.setSecure(true);
//        cookie.setPath("/");
//        cookie.setHttpOnly(true); //JavaScript에서 쿠키에 접근하는 것을 방지하여 XSS 공격을 막는 데 도움을 줍니다.
//
//        return cookie;
//    }
}
