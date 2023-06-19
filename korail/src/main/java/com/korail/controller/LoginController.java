	package com.korail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.MemberService;
import com.korail.vo.MemberVo;
import com.korail.vo.ReservationVo;
import com.korail.vo.SessionVo;

@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;

	
	/**
	 * logout.do - �α׾ƿ�
	 */
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		//String id = (String)session.getAttribute("id");
		SessionVo svo = (SessionVo)session.getAttribute("svo"); 
		if(svo != null) {
			session.invalidate();
			model.addObject("logout_result", "ok");
		}
		
		model.setViewName("main_train");
		
		return model;
	}
	
	
	/**
	 * reservation_login.do - ����Ȯ�� ȸ��/��ȸ�� �α��� ������
	 */
	@RequestMapping(value="/login2.do", method=RequestMethod.GET)
	public String reservation_login() {
		
		return "/reservationlist/login2";
	} 
	
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		
		return "/login/login1";
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * login_proc.do - �α��� ó��
	 */
	@RequestMapping(value="/login_proc.do", method=RequestMethod.POST)
	public ModelAndView login_proc(MemberVo memberVo, HttpSession session, String userId) {
		
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		
		
		ModelAndView model = new ModelAndView();
		SessionVo svo = memberService.getLoginResult(memberVo);
		
		
		if(svo != null) {
			session.setAttribute("svo" , svo);
			//index �̵�
			//viewName = "index";  viewResolver�� ȣ��--> index.jsp: header.do,footer.do ȣ��ȵ�
			if(memberVo.getPagename().equals("mainlogin")) {
				model.addObject("login_result", "ok");
				model.setViewName("redirect:/train_reservation_rotinf.do"); //sendRedirect 
			
			}else if(memberVo.getPagename().equals("reservation")){
				 rvo.setSeatNum(memberVo.getSeatNum());
				 rvo.setTicketQty(memberVo.getTicketQty());
				 rvo.setId(memberVo.getId()); 
				 
				model.setViewName("redirect:/train_reservation_stplcfmpym1.do");
			}else if(memberVo.getPagename().equals("reservationlist")) {
				session.setAttribute("id", memberVo.getId());
				model.setViewName("redirect:/reservation_main.do");
			}
		}else{
			model.setViewName("redirect:/login_fail.do");
		}
		
		return model;
	}	
	
	/*
	 * �α��� ���� 
	 */
	@RequestMapping(value="/login_fail.do", method=RequestMethod.GET)
	public String login_fail() {
		
		return "/login/login_fail";
	}
	
}
