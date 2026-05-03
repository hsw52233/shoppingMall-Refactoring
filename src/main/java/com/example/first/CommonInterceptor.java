package com.example.first;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommonInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("customerMail") != null) {
			log.debug("이미 로그인중 ");
			response.sendRedirect(request.getContextPath()+"/common/home");
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
