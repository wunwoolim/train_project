package com.korail.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.NoticeService;
import com.korail.service.PageServiceImpl;
import com.korail.vo.NoticeVo;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@RequestMapping(value="/notice_list.do", method=RequestMethod.GET)
	public ModelAndView notice_list(String page) {
		ModelAndView model = new ModelAndView();
		Map<String, Integer> param = pageService.getPageResult(page, "notice");
		ArrayList<NoticeVo> list = noticeService.getSelect(param.get("startCount"), param.get("endCount"));
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/notice/notice_list");
		return model;
	}
	
	@RequestMapping(value="/notice_content.do", method=RequestMethod.GET)
	public ModelAndView notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		
		NoticeVo noticeVo = noticeService.getSelect(nid);
		if(noticeVo != null) {
			noticeService.getUpdateHits(nid);
		}
		
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/notice/notice_content");
		
		return model;
	}
	
	@RequestMapping(value="/notice_list_search.do", method=RequestMethod.POST)
	public ModelAndView notice_list_search(String page, String category, String cvalue) {
		System.out.println(page);
		System.out.println(category);
		System.out.println(cvalue);
		Map<String, Integer> param = null;
		
		ModelAndView model = new ModelAndView();
		if(category.equals("all")) {
			param = pageService.getPageResult(page, "notice");
		} else {
			param = pageService.getPageResult(page, "notice", category, cvalue);
		}
		
		ArrayList<NoticeVo> list = noticeService.getList(param.get("startCount"), param.get("endCount"), category, cvalue);
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("notice/notice_list");
		
		return model;
	}
	
	
}

