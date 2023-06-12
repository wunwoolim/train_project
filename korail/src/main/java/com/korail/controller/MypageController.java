package com.korail.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.korail.service.MypageService;

@Controller
public class MypageController {
		
		@Autowired
		private MypageService mypageService;
	
		@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
		public String my_page() {
			return "/my_page/my_page";
		}
		
		@RequestMapping(value="/mypage_modal.do", method=RequestMethod.GET)
		public String my_page_modal() {
			return "/my_page/mypage_modal";
		}
		
		@RequestMapping(value="/mypage_cpassProc.do", method=RequestMethod.POST)
		public void my_page_cpass(String npass, String cpass) {
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("npass", npass);
			param.put("cpass", cpass);
			mypageService.cpassProc(param);
		}
}
