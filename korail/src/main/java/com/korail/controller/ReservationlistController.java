package com.korail.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.OrderService;
import com.korail.vo.OrderVo;

@Controller
public class ReservationlistController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * reservation_main.do - ���ų���
	 */
	@RequestMapping(value="/reservation_main.do", method=RequestMethod.GET)
	public ModelAndView reservation_main(String id) {
		ModelAndView model = new ModelAndView();
		
		ArrayList<OrderVo> orderList = orderService.getSelect();
			
		
		model.addObject("orderList", orderList);
		model.setViewName("/reservationlist/reservation_main");
		
		return model;
		
	}
	
	/**
	 * reservCancel_check.do - ������� ó��
	 */
	@RequestMapping(value="/reservCancel_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String reservCancel_check(String reservnum) {	//�ݵ�� ���ڿ��� �Ѱܾ� �ϱ⶧���� Ÿ���� String
		return orderService.getCancelResult(reservnum); 
	}
	
	
	/**
	 * reservation_receipt.do - ������ ��
	 */
	@RequestMapping(value="/reservation_receipt.do", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reservation_receipt(String reservnum) {
		ModelAndView model = new ModelAndView();
		
		OrderVo orderVo = orderService.getSelected(reservnum);
		
		model.addObject("ovo", orderVo);
		model.setViewName("/reservationlist/reservation_receipt");
		
		return model;
	}
	
	/**
	 * reservation_hometicket.do - ȨƼ�� ��
	 */
	@RequestMapping(value="/reservation_hometicket.do", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reservation_hometicket(String reservnum) {
		ModelAndView model = new ModelAndView();
		
		OrderVo orderVo = orderService.getSelected(reservnum);
		
		model.addObject("ovo", orderVo);
		model.setViewName("/reservationlist/reservation_hometicket");
		
		return model;
	}
	
	
	/**
	 * reservation_update.do - ���� ���� ��
	 */
	@RequestMapping(value="/reservation_update.do", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reservation_update(String reservnum) {
		ModelAndView model = new ModelAndView();
		
		OrderVo orderVo = orderService.getSelected(reservnum);
		
		model.addObject("ovo", orderVo);
		model.setViewName("/reservationlist/reservation_update");
		
		return model;
	}
	
	
	
	/**
	 * admin_trainlist.do - ktx ����Ʈ - ������������ 
	 */
	@RequestMapping(value="/admin_trainlist.do", method=RequestMethod.GET)
	public String admin_trainlist() {
		
		return "/admin/admin_trainlist";
	}
	
	
	/**
	 * admin_reservationlist.do - ���� ��ü ����Ʈ - ������������ 
	 */
	@RequestMapping(value="/admin_reservationlist.do", method=RequestMethod.GET)
	public ModelAndView admin_reservationlist() {
		
		ModelAndView model = new ModelAndView();
		
		ArrayList<OrderVo> orderList = orderService.getOrderSelect();
		
		model.addObject("orderList", orderList);
		model.setViewName("/admin/admin_reservationlist");
		
		return model;
	}
	
	
	
	/**
	 * admin_cancellist.do - ������� ��ü ����Ʈ - ������������ 
	 */
	@RequestMapping(value="/admin_cancellist.do", method=RequestMethod.GET)
	public ModelAndView admin_cancellist() {
		ModelAndView model = new ModelAndView();
		
		ArrayList<OrderVo> orderList = orderService.getOrderSelect();
		
		model.addObject("orderList", orderList);
		model.setViewName("/admin/admin_cancellist");
		
		return model;
	}
	
	
	/**
	 * admin_updatetable.do - ������� ��ü ����Ʈ - ������������ 
	 */
	@RequestMapping(value="/reservation_updatetable.do", method=RequestMethod.GET)
	public String reservation_updatetable() {
		
		return "/reservationlist/reservation_updatetable";
	} 
	
	/**
	 * admin_updatetable.do - ������� ��ü ����Ʈ - ������������ 
	 */
	@RequestMapping(value="/reservation_login.do", method=RequestMethod.GET)
	public String reservation_login() {
		
		return "/reservationlist/reservation_login";
	} 
	
	
	
}//class
