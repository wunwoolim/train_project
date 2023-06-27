package com.korail.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.korail.vo.SessionVo;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		SessionVo svo = (SessionVo) session.getAttribute("svo");

		if (svo == null) {
			String requestURI = request.getRequestURI();
			if (requestURI.equals("/ktx/reservation_main.do")) {
				response.sendRedirect("/ktx/login2.do");
			} else if (requestURI.equals("/ktx/mypage.do")) {
				response.sendRedirect("/ktx/mylogin.do");
			} else if (requestURI.equals("s_reservation.do")) {
				response.sendRedirect("/ktx/s_reservation.do");
			} else {
				response.sendRedirect("/ktx/login.do");
			}
		} else {
			String sessionId = "test";
			if (session.getId().equals(sessionId)) {
				session.setMaxInactiveInterval(-1);
			}
			return true;
		}
		return false;
	}
}
