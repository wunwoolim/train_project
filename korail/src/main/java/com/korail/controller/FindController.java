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
	
	
			
		@RequestMapping(value="/find_id1.do")
		public String findid() throws Exception{
			
			return "/find_id/find_id1";
		}
		
		@RequestMapping(value="/find_pass.do", method=RequestMethod.GET)
		public String findpass() {
			
			return "/find_pass/find_pass1";
		}
		
		/**
		 * 메일 인증 테스트 화면
		 */
		@RequestMapping(value="/mailAuthTest.do", method=RequestMethod.GET)
		public String mailAuth() {
			return "/find_id/mailAuthTest";
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
		
	
	
}
