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
import com.korail.vo.CardinfoVo;
import com.korail.vo.OrderVo;
import com.korail.vo.SessionVo;
import com.korail.vo.UpdateVo;

@Controller
public class ReservationlistController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	/**
	 * reservation_main.do - ���ų���
	 */
	@RequestMapping(value="/reservation_main.do", method=RequestMethod.GET)
	public ModelAndView reservation_main(OrderVo orderVo, HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		SessionVo svo = (SessionVo) session.getAttribute("svo");
		String id = svo.getId();
		String cardnum = svo.getCardnum();
		
		System.out.println(id);
		System.out.println(cardnum);
		
	    if(id == null) {
	        // userId ���� ���� ��� �α��� �������� �����̷�Ʈ
	        model.setViewName("redirect:/login2.do");
	        return model;
	    }
	    
	    // �α����� ������� id�� cardnum�� �����Ͽ� ��ȸ
	    orderVo.setId(id);
	    orderVo.setCardnum(cardnum);
	    
		ArrayList<OrderVo> orderList = orderService.getSelect(orderVo);
	    
		System.out.println(orderList.get(0).getCardnum());
		
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
	 * reservation_update.do - ���� ���� 1��° ������
	 */
	@RequestMapping(value="/reservation_update.do", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reservation_update(HttpSession session, String reservnum) {
		ModelAndView model = new ModelAndView();
		
		OrderVo orderVo = orderService.getSelected(reservnum);
		
		UpdateVo uvo = new UpdateVo();
		uvo.setReservnum(reservnum);
		
		model.addObject("ovo", orderVo);
		
		model.setViewName("/reservationlist/reservation_update");
		
		session.setAttribute("uvo", uvo);
		
		return model;
	}
	
	
	
	/**
	 * reservation_updatetime.do - ���ź��� 2��° ������ (������ȸ)
	 */
	@RequestMapping(value="/reservation_updatetime.do", method=RequestMethod.GET)
	public String reservation_updatetime(HttpSession session, String traintime,String depPlaceId,String arrPlaceId ) {
		
		UpdateVo uvo = (UpdateVo)session.getAttribute("uvo");
		
		System.out.println(uvo.getReservnum());
		uvo.setRtime(traintime);
		uvo.setStartId(depPlaceId);
		uvo.setEndId(arrPlaceId);
		
		return "/reservationlist/reservation_updatetime";
	} 
	
	
	
	/**
	 * reservation_updatechair.do - ���ź��� 3��° ������ - �¼�����
	 */
	@RequestMapping(value="/reservation_updatechair.do",method=RequestMethod.POST)
	public String reservation_updatechair(UpdateVo updateVo, HttpSession session,
			String depplacename, String arrplacename, String start_date, String end_date, String traingradename, String trainno, String adultcharge, String rtimes) {
		
		//System.out.println(depplacename);
		UpdateVo uvo = (UpdateVo)session.getAttribute("uvo");
		
		uvo.setDepplacename(depplacename);
		uvo.setArrplacename(arrplacename);
		uvo.setStart_date(start_date);
		uvo.setEnd_date(end_date);
		uvo.setTraingradename(traingradename);
		uvo.setTrainno(trainno);
		uvo.setAdultcharge(adultcharge);
		uvo.setRtimes(rtimes);
			
		
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
		
		System.out.println(seatNum);
		System.out.println(ticketQty);
		
		
		//model.addObject("seatNum", reservationVo.getSeatNum() );
		
		//model.setViewName("/reservation/train_reservation_stplcfmpym");
		return "/reservationlist/reservation_updatepay";
	}
	
	
	/**
	 * reservation_update_proc - ������ - ���ź��� ó��
	 */
	@RequestMapping(value="/reservation_updatepay_proc.do", method=RequestMethod.POST)
	public String reservation_updatepay_proc(HttpSession session, OrderVo orderVo, CardinfoVo cardVo) {
		String viewName="";
		UpdateVo uvo = (UpdateVo)session.getAttribute("uvo");
	
		/*
		 * UUID uuid = UUID.randomUUID();
		 * 
		 * cardVo.setRecognizenum(uuid.toString().replaceAll("-", "").substring(0, 10));
		 */
		orderVo.setReservnum(uvo.getReservnum());
		orderVo.setSstation(uvo.getDepplacename());
		orderVo.setStime(uvo.getStart_date());
		orderVo.setDtime(uvo.getEnd_date());
		orderVo.setDstation(uvo.getArrplacename());
		orderVo.setChairnum(uvo.getSeatNum());
		/* orderVo.setId(); */
		orderVo.setDepPlaceId(uvo.getStartId());
		orderVo.setArrPlaceId(uvo.getEndId());
		orderVo.setDepPlandTime(uvo.getRtimes());
		orderVo.setCardnum(cardVo.getCardnum());
		orderVo.setPrice(Integer.parseInt(uvo.getAdultcharge()));
		orderVo.setTrainnum(Integer.parseInt(uvo.getTrainno()));
		orderVo.setTicketqty(Integer.parseInt(uvo.getTicketQty()));
		
		int result = orderService.getPaymentUpdate(orderVo);
		//cardService.getPaymentUpdate(cardVo);
		if(result == 1) {
			viewName = "redirect:/reservation_main.do";
		}else {
			//����������
		}
		return viewName;
	}
	
	
	
	
	
	/**
	 * admin_main.do - ������ ����
	 */
	@RequestMapping(value="/admin_main.do", method=RequestMethod.GET)
	public String admin_main() {
		
		return "/admin/admin_main";
	} 
	
	
	
	
	/**
	 * cardnum_check_proc.do - �α���2 ī���ȣ�� ��ȸ�ϱ� ó��
	 */
	 @RequestMapping(value="/cardnum_check_proc.do", method=RequestMethod.POST)
	 public ModelAndView cardnum_check_proc(String cardnum, String userId, HttpSession session) {
		 ModelAndView model = new ModelAndView();
		 int result = orderService.getCardnum(cardnum);
		 
		 if (result == 1) {
		        // ī���ȣ ��ȸ ���� �� ���ǿ� ����� ���� ����
		        SessionVo svo = new SessionVo();
		        svo.setId(userId);
		        svo.setCardnum(cardnum);
		        session.setAttribute("svo", svo);

		        model.setViewName("redirect:/reservation_main.do");
		 } else {
		        model.setViewName("redirect:/login_fail.do");
		 }
		 
		 return model;
	 }
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
