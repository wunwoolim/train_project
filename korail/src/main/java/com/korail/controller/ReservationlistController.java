package com.korail.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.OrderService;
import com.korail.vo.OrderVo;
import com.korail.vo.ReservationVo;
import com.korail.vo.UpdateVo;

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
	 * reservation_login.do - ����Ȯ�� ȸ��/��ȸ�� �α��� ������
	 */
	@RequestMapping(value="/reservation_login.do", method=RequestMethod.GET)
	public String reservation_login() {
		
		return "/reservationlist/reservation_login";
	} 
	
	
	
	
	/**
	 * reservation_update.do - ���� ���� 1��° ������
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
	 * reservation_updatetime.do - ���ź��� 2��° ������ (������ȸ)
	 */
	@RequestMapping(value="/reservation_updatetime.do", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reservation_updatetime(String reservnum) {
		ModelAndView model = new ModelAndView();
		
		OrderVo orderVo = orderService.getSelected(reservnum);
		
		model.addObject("ovo", orderVo);
		model.setViewName("/reservationlist/reservation_updatetime");
		
		return model;
	} 
	
	
	
	/**
	 * reservation_updatechair.do - ���ź��� 3��° ������ - �¼�����
	 */
	@RequestMapping(value="/reservation_updatechair.do",method=RequestMethod.POST)
	public String reservation_updatechair(UpdateVo updateVo, HttpSession session,
			String depplacename, String arrplacename, String start_date, String end_date, String traingradename, String trainno, String adultcharge, String rtimes) {
		
		//System.out.println(depplacename);
		
		UpdateVo uvo = new UpdateVo();
		
		uvo.setDepplacename(depplacename);
		uvo.setArrplacename(arrplacename);
		uvo.setStart_date(start_date);
		uvo.setEnd_date(end_date);
		uvo.setTraingradename(traingradename);
		uvo.setTrainno(trainno);
		uvo.setAdultcharge(adultcharge);
		uvo.setRtimes(rtimes);
		
		
		session.setAttribute("uvo", uvo);
		
		return "/reservationlist/reservation_updatechair";
	}
	
	/**
	 *   reservation_updatepay.do - ���ź��� 4��° ������ - ��ȸ�� ���� 
	 */
	@RequestMapping(value="/reservation_updatepay.do", method=RequestMethod.POST)
	public String reservation_updatepay(UpdateVo updateVo, HttpSession session, String seatNum, String ticketQty) {
		//ModelAndView model = new ModelAndView();
		UpdateVo uvo = (UpdateVo)session.getAttribute("uvo");
		
		uvo.setSeatNum(seatNum);
		uvo.setTicketQty(ticketQty);
		
		
		//model.addObject("seatNum", reservationVo.getSeatNum() );
		
		//model.setViewName("/reservation/train_reservation_stplcfmpym");
		return "/reservationlist/reservation_updatepay";
	}
	
}//class
