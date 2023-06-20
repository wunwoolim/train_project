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
		} else {
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
		ArrayList<NoticeVo> nlist = noticeService.getNid(nid);
		int pidx = 0;
		int nidx = 0;
		int idx = 0;
		
		for(int i=0; i<nlist.size(); i++) {
			NoticeVo nvo = nlist.get(i);
			if(nvo.getNid().equals(nid)) {
				idx = i;
				if(idx == 0) {
					pidx = nlist.size()-1;
					nidx = idx+1;
				} else if(idx == nlist.size()-1) {
					pidx = idx-1;
					nidx = 0;
				} else {
					pidx = idx-1;
					nidx = idx+1;
				}
			}
			
		}
		
		if(noticeVo != null) {
			noticeService.getUpdateHits(nid);
		}
		
		model.addObject("noticeVo", noticeVo);
		model.addObject("nprev", nlist.get(pidx).getNid());
		model.addObject("nnext", nlist.get(nidx).getNid());
		
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
			
		} else {
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
	
		/*@RequestMapping(value="/notice_list_nid.do", method= RequestMethod.GET)	
		public ModelAndView notice_list_nid(String nid) {
			ModelAndView model = new ModelAndView();
			ArrayList<NoticeVo> nlist = noticeService.getNid(nid);
			
			model.addObject("nlist", nlist);
			model.setViewName("notice/notice_content");
			return model;
		}*/
	
}