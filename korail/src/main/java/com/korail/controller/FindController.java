package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FindController {
		
			
		@RequestMapping(value="/find_id1.do")
		public String findid() throws Exception{
			
			return "/find_id/find_id1";
		}
		
		@RequestMapping(value="/find_pass.do", method=RequestMethod.GET)
		public String findpass() {
			
			return "/find_pass/find_pass1";
		}
		

		
	
	
}
