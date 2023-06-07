package com.korail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.OrderService;
import com.korail.vo.OrderVo;
import com.korail.vo.ReservationVo;


@Controller
public class ReservationController {
	@Autowired
	private OrderService orderService;
	
	/*
	 * ���� �Ϸ� ������ 
	 */
	@RequestMapping(value="/train_reservation_pymcfm.do", method=RequestMethod.POST)
	public OrderVo train_reservation_pymcfm(HttpSession session,String seatNum, Integer ticketQty,String startId ,String endId,String rtime
			,String depplacename, String arrplacename, String start_date, String end_date, String traingradename, Integer trainno, Integer adultcharge, String rtimes) {
		
		OrderVo orderVo = (OrderVo)session.getAttribute("rvo");
		
		orderVo.setSstation(depplacename);
		orderVo.setRdate(rtime);
		orderVo.setStime(start_date);
		orderVo.setDtime(end_date);
		orderVo.setDstation(arrplacename);
		/* orderVo.setReservnum(stime); */
		orderVo.setChairnum(seatNum);
		/* orderVo.setId(memberId); */
		orderVo.setDepPlaceId(startId);
		orderVo.setArrPlaceId(endId);
		orderVo.setDepPlandTime(rtimes);
		/* orderVo.setCardnum(stime); */
		orderVo.setPrice(adultcharge);
		orderVo.setTrainnum(trainno);
		orderVo.setTicketqty(ticketQty);
		
		
		return orderVo;
	}
	
	
	/*
	 * ȸ�� ���� ������
	 */
	@RequestMapping(value="/train_reservation_member_stplcfmpym.do", method=RequestMethod.POST)
	public String train_reservation_member_stplcfmpym() {
		
		return "/reservation/train_reservation_member_stplcfmpym";
	}
	
	/*
	 * ��ȸ�� ���� ������
	 */
	@RequestMapping(value="/train_reservation_stplcfmpym.do", method=RequestMethod.POST)
	public String train_reservation_stplcfmpym(ReservationVo reservationVo, HttpSession session, String seatNum, String ticketQty) {
		//ModelAndView model = new ModelAndView();
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		
		rvo.setSeatNum(seatNum);
		rvo.setTicketQty(ticketQty);
		
		
		//model.addObject("seatNum", reservationVo.getSeatNum() );
		
		//model.setViewName("/reservation/train_reservation_stplcfmpym");
		return "/reservation/train_reservation_stplcfmpym";
	}
	
	/*
	 * ���� �¼� ���� ������
	 */
	@RequestMapping(value="/train_reservation_satschc.do",method=RequestMethod.POST)
	public String train_reservation_satschc(ReservationVo reservationVo, HttpSession session,
			String depplacename, String arrplacename, String start_date, String end_date, String traingradename, String trainno, String adultcharge, String rtimes) {
		//ModelAndView model = new ModelAndView();
		
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		rvo.setDepplacename(depplacename);
		rvo.setArrplacename(arrplacename);
		rvo.setStart_date(start_date);
		rvo.setEnd_date(end_date);
		rvo.setTraingradename(traingradename);
		rvo.setTrainno(trainno);
		rvo.setAdultcharge(adultcharge);
		rvo.setRtimes(rtimes);
		
		
		/*
		 * model.addObject("depplacename", reservationVo.getDepplacename());
		 * model.addObject("arrplacename", reservationVo.getArrplacename());
		 * model.addObject("start_date", reservationVo.getStart_date());
		 * model.addObject("end_date", reservationVo.getEnd_date());
		 * model.addObject("traingradename", reservationVo.getTraingradename());
		 * model.addObject("trainno", reservationVo.getTrainno());
		 * model.addObject("adultcharge", reservationVo.getAdultcharge());
		 * model.addObject("rtimes", reservationVo.getRtimes());
		 * 
		 * model.setViewName("/reservation/train_reservation_satschc");
		 */
		
		return "/reservation/train_reservation_satschc";
	}
	
	
	/*
	 * ���� �ð� ���� ������
	 */
	@RequestMapping(value="/train_reservation_alcnsrch.do", method=RequestMethod.GET)
	public String train_reservation_alcnsrch(HttpSession session,String startId ,String endId,String rtime) {
		 
		 ReservationVo rvo = new ReservationVo();
		
		 
		rvo.setStartId(startId);
		rvo.setEndId(endId);
		rvo.setRtime(rtime);
		
		session.setAttribute("rvo", rvo);
		
		return "/reservation/train_reservation_alcnsrch";
	}
	
	
	/*
	 * ���� ���� ������ 
	 */
	@RequestMapping(value="/train_reservation_rotinf.do", method=RequestMethod.GET)
	public String train_reservation_rotinf() {
		
		return "/reservation/train_reservation_rotinf";
	}
}
