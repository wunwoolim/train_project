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
	 * 메일 인증 테스트 화면
	 */
	@RequestMapping(value="/joinAuth.do", method=RequestMethod.GET)
	public String mailAuth() {
		return "/join/join2";
	}
	
	/**
	 * 메일 인증 체크
	 */
	@ResponseBody
	@RequestMapping(value="/mailCheck.do", method=RequestMethod.GET)
	public String mailCheck(String email) {
		System.out.println("email------->>" + email);
		
		return mailService.joinEmail(email);
	}
	
	
	/*
	 * 회원가입 사용약관 동의 페이지
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		
		return "/join/join";
	}
	
	
	

	/**
	 * id_check.do - 아이디 중복체크 처리
	 */
	@RequestMapping(value="/id_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String id_check(String id) {
		
		System.out.println(id);
		int result = memberService.getIdCheckResult(id);
		return String.valueOf(result);
	}
	
	/**
	 * id_check.do - 아이디 중복체크 처리
	 */
	@RequestMapping(value="/email_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String email_check(String email) {
		
		System.out.println("email"+email);
		int result = memberService.getEmailCheckResult(email);
		return String.valueOf(result);
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 *  join_proc.do - 회원가입 처리
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
			//회원가입 실패 - 에러페이지 호출
		}
		
		return model;
	}
	
	/*
	 *  joinpage.do - 회원가입 폼
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
