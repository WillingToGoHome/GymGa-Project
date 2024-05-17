package com.willingtogohome.gymga.login.config;

import com.willingtogohome.gymga.login.common.UserRole;
import com.willingtogohome.gymga.login.config.handler.AuthFailHandler;
import com.willingtogohome.gymga.login.config.handler.AuthSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    /* 비밀번호 암호화 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* 정적 리소스에 대한 요청은 제외하는 설정 */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers("/fonts/**","/img/**","/css/**","/images/**","/styles/**", "/static/emp/**","/static/fac/**","/static/pass/**","/uploadFiles/**","/imageFile/**");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        /* 요청에 대한 권한 체크 */
        http.authorizeHttpRequests( auth -> {
            auth.requestMatchers("/login", "/login/admin/regist", "/", "/main", "/login/auth/*").permitAll();

            auth.requestMatchers("/main", "/emp/**", "/fac/**","/pass/**","/sale/**","/schedule/**","/user/**","/imageFile/**").hasAnyAuthority(UserRole.ADMIN.getRole(), UserRole.USER.getRole());
//            auth.requestMatchers("/main").hasAnyAuthority(UserRole.USER.getRole());
//            auth.anyRequest().authenticated();


        }).formLogin( login -> {
            login.loginPage("/login");
            login.usernameParameter("user");
            login.passwordParameter("pass");
            login.defaultSuccessUrl("/main", true);
            login.successHandler(authSuccessHandler);
            login.failureHandler(authFailHandler);

        }).logout( logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/main/logout"));
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.logoutSuccessUrl("/login");

        }).sessionManagement( session -> {
            session.maximumSessions(2);
            session.invalidSessionUrl("/");


        }).csrf( csrf -> csrf.disable());

        return http.build();
    }
}
