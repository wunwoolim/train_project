	package com.korail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.MemberService;
import com.korail.vo.MemberVo;
import com.korail.vo.SessionVo;

@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;

	
	/**
	 * logout.do - �α׾ƿ�
	 */
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		//String sid = (String)session.getAttribute("sid");
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		if(svo != null) {
			session.invalidate();
			model.addObject("logout_result", "ok");
		}
		
		model.setViewName("index");
		
		return model;
	}
	
	
	
	
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		
		return "/login/login";
	}
	
	
	/**
	 * login_proc.do - �α��� ó��
	 */
	@RequestMapping(value="/login_proc.do", method=RequestMethod.POST)
	public ModelAndView login_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		int result = memberService.getLoginResult(memberVo);
		
		if(result == 1) {
			//index �̵�
			//viewName = "index";  viewResolver�� ȣ��--> index.jsp: header.do,footer.do ȣ��ȵ�
			model.addObject("login_result", "ok");
			model.setViewName("redirect:/train_reservation_rotinf.do");  //sendRedirect 
		}else {
			//login_fail.jsp
			model.setViewName("redirect:/login_fail.do");
		}
		
		return model;
	}	
	
	/*
	 * �α��� ���� 
	 */
	@RequestMapping(value="/login_fail.do", method=RequestMethod.GET)
	public String login_fail() {
		
		return "/login/login_fail";
	}
	
}
