package com.korail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.MemberService;
import com.korail.vo.MemberVo;


@Controller
public class JoinController {
	@Autowired
	private MemberService memberService;
	
	
	
	
	
	
	/*
	 * 회원가입 사용약관 동의 페이지
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		
		return "/join/join";
	}
	
	
	/*
	 * 회원가입 인증 페이지
	 */
	
	
	@RequestMapping(value="/join2.do", method=RequestMethod.GET)
	public String join2() {
		
		return "/join/join2";
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
	
	
	
	
	
	
	
	
	
	
	/*
	 *  join_proc.do - 회원가입 처리
	 */
	@RequestMapping(value="/join_proc.do", method=RequestMethod.POST)
	public ModelAndView join_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();		
		int result = memberService.getJoinResult(memberVo);
		if(result == 1) {
			model.addObject("join_result", "ok");
			model.setViewName("/login/login");
		}else {
			//회원가입 실패 - 에러페이지 호출
		}
		
		return model;
	}
	
	
	/*
	 *  join3.do - 회원가입 폼
	 */
	
	
	@RequestMapping(value="/join3.do", method=RequestMethod.GET)
	public String join3() {
		
		return "/join/join3";
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
