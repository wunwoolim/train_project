package com.korail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.korail.service.MailSendService;

@Controller
public class FindController {
			
	@Autowired
	private MailSendService mailService;
	
	/**
	 * 메일 인증 테스트 화면
	 */
	@RequestMapping(value="/findAuth.do", method=RequestMethod.GET)
	public String mailAuth() {
		return "/find_id/find_id1";
	}
	
		
		@RequestMapping(value="/find_id2.do")
		public String findid2(){
			
			
			
			return "/find_id/find_id2";
		}
		
		@RequestMapping(value="/find_pass.do", method=RequestMethod.GET)
		public String findpass() {
			
			return "/find_pass/find_pass1";
		}
		
		
	
}
