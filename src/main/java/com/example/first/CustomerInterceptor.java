package com.example.first;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class CustomerInterceptor implements HandlerInterceptor {
	// 고객 로그인 인터셉트
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("CustomerInterceptor 요청: "+request.getRequestURI().toString());
		
		HttpSession session = request.getSession();
		
		// 고객 확인
		if(session.getAttribute("customerMail") == null) {
			log.debug("고객 로그인 실패 - 리다이렉트");
			response.sendRedirect(request.getContextPath()+"/common/home");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
				
	}
}
