package com.koreamall.handler;


import com.koreamall.dto.user.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Log4j2
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println(authentication);
        Object principal = authentication.getPrincipal();
        authentication.getAuthorities();
        if(principal instanceof UserDTO) {
            response.sendRedirect("/main");
            return;
        }
        // 로그인안되면 세션 초기화
        authentication.setAuthenticated(false);
        request.getSession().invalidate();
        response.sendRedirect("/user/register?isNotRegistered");
    }
}
