package com.korail.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.PageServiceImpl;
import com.mycgv_jsp.vo.NoticeVo;

@Controller
public class AdminController {
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String page) {
		ModelAndView model = new ModelAndView();
		Map<String, Integer> param = pageService.getPageResult(page, "notice");		
		ArrayList<NoticeVo> list 
			= noticeService.getSelect(param.get("startCount"), param.get("endCount"));
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/notice/admin_notice_list");
		
		return model;
	}
	
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public String admin_notice_delete() {
		return "admin/admin_notice_delete";
	}
	
	@RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
	public String admin_notice_list() {
		return "admin/admin_notice_list";
	}
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public String admin_notice_update() {
		return "admin/admin_notice_update";
	}
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "admin/admin_notice_write";
	}
	
	

}
