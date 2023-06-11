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
public class AdminController {
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private NoticeService noticeService;
	
	//공지사항 리스트
	@RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
	public ModelAndView notice_list(String page) {
		ModelAndView model = new ModelAndView();		
		Map<String, Integer> param = pageService.getPageResult(page, "notice");			
		ArrayList<NoticeVo> list 
			= noticeService.getSelect(param.get("startCount"), param.get("endCount"));
		
		model.addObject("list", list);
		model.addObject("totals", param.get("dbCount"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/admin_notice_list");		
		
		return model;
	}
	
	//공지사항 상세내용
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getSelect(nid);
		
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/admin_notice_content");		
		
		return model;
	}
	
	//공지사항 등록
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "admin/admin_notice_write";
	}
	
	//공지사항 등록 처리
	@RequestMapping(value="/admin_notice_write_proc.do", method=RequestMethod.POST)
	public String admin_notice_write_proc(NoticeVo noticeVo) {
		String viewName = "";
		int result = noticeService.getInsert(noticeVo);
		if(result == 1) {
			viewName = "redirect:/admin_notice_list.do";
		}
		return viewName;
	}
	
	//공지사항 수정
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeVo noticeVo = noticeService.getSelect(nid);
		
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/admin_notice_update");
		return model;
	}
	
	//공지사항 수정 처리
	@RequestMapping(value="/admin_notice_update_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_update_proc(NoticeVo noticeVo) {
		ModelAndView model = new ModelAndView();
		
		int result = noticeService.getUpdate(noticeVo);
		if(result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}
		
		return model;
	}
	
	//공지사항 삭제
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid) {
		ModelAndView model = new ModelAndView();
		model.addObject("nid", nid);
		model.setViewName("/admin/admin_notice_delete");
		
		return model;
	}
	
	//공지사항 삭제 처리
	@RequestMapping(value="/admin_notice_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_delete_proc(String nid) {
		ModelAndView model = new ModelAndView();
		
		int result = noticeService.getDelete(nid);
		if(result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}
		
		return model;
	}
	
}
