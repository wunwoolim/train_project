package com.korail.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.MemberService;
import com.korail.service.PageServiceImpl;
import com.korail.vo.MemberVo;

@Controller
public class Admin_memberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/admin_member_search.do", method=RequestMethod.POST)
	public ModelAndView admin_member_search(String page, String category,String cvalue) {
		System.out.println(page);
		System.out.println(category);
		System.out.println(cvalue);
		Map<String, Integer> param = null;
		
		ModelAndView model = new ModelAndView();
		if(category.equals("total")){
			param = pageService.getPageResult(page, "member");
		}else {
			param = pageService.getPageResult(page, "member", category, cvalue);		
			
		}
		ArrayList<MemberVo> list 
		= memberService.getList(param.get("startCount"), param.get("endCount"),category, cvalue);
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/admin_member_list");
		
		return model;
	}

	
	
	@RequestMapping(value="/admin_member.do", method=RequestMethod.GET)
	public ModelAndView admin_member_list(String page) {
		ModelAndView model = new ModelAndView();
		Map<String, Integer> param = pageService.getPageResult(page, "member","all","all");		
		ArrayList<MemberVo> list 
			= memberService.getList(param.get("startCount"), param.get("endCount"));
		System.out.println(param.get("dbCount"));
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/admin_member_list");
		
		return model;
	}
		
}
