package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
	
		@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
		public String my_page() {
			
			return "/my_page/my_page";
		}
		
		@RequestMapping(value="/mypage_modal.do", method=RequestMethod.GET)
		public String my_page_modal() {
			
			return "/my_page/mypage_modal";
		}
		
}
