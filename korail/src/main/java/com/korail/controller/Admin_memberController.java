package com.korail.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.vo.MemberVo;

@Controller
public class Admin_memberController {

	/**
	 *  회원관리 - 회원 전체 리스트 
	 * @return
	 */
	/*
	 * @RequestMapping(value="/admin_member.do", method=RequestMethod.GET) public
	 * ModelAndView board_list(String page) { ModelAndView model = new
	 * ModelAndView(); Map<String, Integer> param = pageService.getPageResult(page,
	 * "member");
	 * 
	 * ArrayList<MemberVo> list = memberService.getSelect(param.get("startCount"),
	 * param.get("endCount"));
	 * 
	 * model.addObject("list", list); model.addObject("totals",
	 * param.get("dbCount")); model.addObject("pageSize", param.get("pageSize"));
	 * model.addObject("maxSize", param.get("maxSize")); model.addObject("page",
	 * param.get("page"));
	 * 
	 * model.setViewName("/admin/admin_member_list");
	 * 
	 * return model; }
	 */
	
	
}
