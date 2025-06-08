package org.example.expert.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Slf4j
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // JwtFilter 에서 넣은 userRole 사용
        String userRole = (String) request.getAttribute("userRole");

        // user의 권한이 ADMIN인지 확인하기
        if (userRole == null || !userRole.equals("ADMIN")) {
            throw new InvalidRequestException("어드민 권한이 필요합니다.");
        }

        // 인증 성공 시 로그 찍기
        log.info("인터셉터 TIME = {}, URI = {}", LocalDateTime.now(), request.getRequestURI());

        return true;
    }
}
