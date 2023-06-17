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
	public ModelAndView notice_list(NoticeVo noticeVo) {
		System.out.println(noticeVo);
		Map<String, Integer> param = null;
		
		ModelAndView model = new ModelAndView();
		if(noticeVo.getCategory().equals("all")) {
			param = pageService.getPageResult(noticeVo.getPage(), "notice", noticeVo.getCategory(), noticeVo.getCvalue());
			System.out.println("noticeVo.getCvalue()---->" + noticeVo.getCvalue());
			System.out.println("noticeVo.getCategory()---->" + noticeVo.getCategory());
			System.out.println("noticeVo.getNtitle()---->" + noticeVo.getNtitle());
			System.out.println("noticeVo.getNid()---->" + noticeVo.getNid());
			System.out.println("noticeVo.getNdate()---->" + noticeVo.getNdate());
			
		} else {
			System.out.println("noticeVo.getCvalue()---->" + noticeVo.getCvalue());
			System.out.println("noticeVo.getCategory()---->" + noticeVo.getCategory());
			System.out.println("noticeVo.getNtitle()---->" + noticeVo.getNtitle());
			System.out.println("noticeVo.getNid()---->" + noticeVo.getNid());
			System.out.println("noticeVo.getNdate()---->" + noticeVo.getNdate());
			param = pageService.getPageResult(noticeVo.getPage(), "notice", noticeVo.getCategory(), noticeVo.getCvalue());
		}
		
		ArrayList<NoticeVo> list = noticeService.getList(param.get("startCount"), param.get("endCount"), noticeVo.getCategory(), noticeVo.getCvalue());
		for(NoticeVo vo : list) {
		}
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
	
	@RequestMapping(value="/notice_list_search.do", method= RequestMethod.POST)
	public ModelAndView notice_list_search(NoticeVo noticeVo) {
		System.out.println(noticeVo);
		Map<String, Integer> param = null;
		
		ModelAndView model = new ModelAndView();
		if(noticeVo.getCategory().equals("all")) {
			param = pageService.getPageResult(noticeVo.getPage(), "notice", noticeVo.getCategory(), noticeVo.getCvalue());
			System.out.println("noticeVo.getCvalue()---->" + noticeVo.getCvalue());
			System.out.println("noticeVo.getCategory()---->" + noticeVo.getCategory());
			System.out.println("noticeVo.getNtitle()---->" + noticeVo.getNtitle());
			System.out.println("noticeVo.getNid()---->" + noticeVo.getNid());
			System.out.println("noticeVo.getNdate()---->" + noticeVo.getNdate());
			
		} else {
			System.out.println("333333");
			System.out.println("noticeVo.getCvalue()---->" + noticeVo.getCvalue());
			System.out.println("noticeVo.getCategory()---->" + noticeVo.getCategory());
			System.out.println("noticeVo.getNtitle()---->" + noticeVo.getNtitle());
			System.out.println("noticeVo.getNid()---->" + noticeVo.getNid());
			System.out.println("noticeVo.getNdate()---->" + noticeVo.getNdate());
			param = pageService.getPageResult(noticeVo.getPage(), "notice", noticeVo.getCategory(), noticeVo.getCvalue());
		}
		
		ArrayList<NoticeVo> list = noticeService.getList(param.get("startCount"), param.get("endCount"), noticeVo.getCategory(), noticeVo.getCvalue());
		for(NoticeVo vo : list) {
		}
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		model.addObject("category", noticeVo.getCategory());
		model.addObject("cvalue", noticeVo.getCvalue());
		
		
		model.setViewName("/notice/notice_list");
		
		return model;
	}
	
		@RequestMapping(value="/notice_list_nid.do", method= RequestMethod.GET)	
		public ModelAndView notice_list_nid(String nid) {
			ModelAndView model = new ModelAndView();
			ArrayList<NoticeVo> nlist = noticeService.getNid(nid);
			System.out.println(nlist);
			
			model.addObject("nlist", nlist);
			model.setViewName("notice/notice_list");
			return model;
		}
	
}