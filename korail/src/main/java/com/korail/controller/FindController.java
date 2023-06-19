package com.korail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.MailSendService;
import com.korail.service.MemberService;
import com.korail.vo.MemberVo;

@Controller
public class FindController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MailSendService mailService;
	
	/**
	 * 메일 인증 테스트 화면
	 */
	@RequestMapping(value="/findAuth.do", method=RequestMethod.GET)
	public String mailAuth() {
		return "/find_id/find_id1";
	}
	
		
		@RequestMapping(value="/find_id2.do", method=RequestMethod.POST)
		public ModelAndView findid2(HttpSession session, String email){
			ModelAndView model = new ModelAndView();
			/* session.setAttribute("mvo", mvo); */
			
			System.out.println("email" + email);
			
			
			MemberVo mvo = memberService.getFindIdResult(email);
			
			
			
			model.addObject("mvo",mvo);
			model.setViewName("/find_id/find_id2");
			return model;
		}
		
		@RequestMapping(value="/find_pass.do", method=RequestMethod.GET)
		public String findpass() {
			
			return "/find_pass/find_pass1";
		}
		
		@RequestMapping(value="/find_pass2.do", method=RequestMethod.POST)
		public ModelAndView findPass2(HttpSession session,String email) {
			ModelAndView model = new ModelAndView();
			System.out.println("email"+email);
			MemberVo mvo = memberService.getFindPassResult(email);
			
			model.addObject("mvo",mvo);
			model.setViewName("/find_pass/find_pass2");
			return model;
			
		}
		
		
	
}
