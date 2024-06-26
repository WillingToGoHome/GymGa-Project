package com.willingtogohome.gymga.login.config.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

//        String script = "<script>alert('로그인이 필요합니다.'); window.location.href='/login';</script>";
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().println(script);
        response.sendRedirect("/login");
    }
}
