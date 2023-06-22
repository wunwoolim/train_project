package com.korail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.MailSendService;
import com.korail.service.MemberService;
import com.korail.vo.MemberVo;


@Controller
public class JoinController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MailSendService mailService;
	
	
	
	
	/**
	 * ���� ���� �׽�Ʈ ȭ��
	 */
	@RequestMapping(value="/joinAuth.do", method=RequestMethod.GET)
	public String mailAuth() {
		return "/join/join2";
	}
	
	/**
	 * ���� ���� üũ
	 */
	@ResponseBody
	@RequestMapping(value="/mailCheck.do", method=RequestMethod.GET)
	public String mailCheck(String email) {
		System.out.println("email------->>" + email);
		
		return mailService.joinEmail(email);
	}
	
	
	/*
	 * ȸ������ ����� ���� ������
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		
		return "/join/join";
	}
	
	
	

	/**
	 * id_check.do - ���̵� �ߺ�üũ ó��
	 */
	@RequestMapping(value="/id_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String id_check(String id) {
		
		System.out.println(id);
		int result = memberService.getIdCheckResult(id);
		return String.valueOf(result);
	}
	
	/**
	 * id_check.do - ���̵� �ߺ�üũ ó��
	 */
	@RequestMapping(value="/email_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String email_check(String email) {
		
		System.out.println("email"+email);
		int result = memberService.getEmailCheckResult(email);
		return String.valueOf(result);
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 *  join_proc.do - ȸ������ ó��
	 */
	@RequestMapping(value="/join_proc.do", method=RequestMethod.POST)
	public ModelAndView join_proc(MemberVo memberVo) {
		System.out.println(memberVo.getPnumber());
		ModelAndView model = new ModelAndView();		
		int result = memberService.getJoinResult(memberVo);
		if(result == 1) {
			model.addObject("join_result", "ok");
			model.setViewName("/login/login1");
		}else {
			//ȸ������ ���� - ���������� ȣ��
		}
		
		return model;
	}
	
	/*
	 *  joinpage.do - ȸ������ ��
	 */
	
	
	@RequestMapping(value="/joinpage.do", method=RequestMethod.GET)
	public String joinpage(HttpSession session, MemberVo mvo) {
			
		session.setAttribute("mvo", mvo);
		
		return "/join/joinpage";
	}
	
	
	
		
	@RequestMapping(value="/joinpolicy.do", method=RequestMethod.GET)
	public String joinpolicy() {
		
		return "/join/joinpolicy";
	}
	
	@RequestMapping(value="/joinpolicy1.do", method=RequestMethod.GET)
	public String joinpolicy1() {
		
		return "/join/joinpolicy1";
	}

	
}
