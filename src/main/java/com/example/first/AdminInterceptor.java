package com.example.first;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("AdminInterceptor 요청 : "+request.getRequestURI().toString());
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginStaff") == null) {
			log.debug("관리자 로그인 실패 - 리다이렉트");
			response.sendRedirect(request.getContextPath()+"/staff/login");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
