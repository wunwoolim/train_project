package com.korail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.korail.vo.ReservationVo;


@Controller
public class ReservationController {
	/*
	 * 결제 완료 페이지 
	 */
	@RequestMapping(value="/train_reservation_pymcfm.do", method=RequestMethod.GET)
	public String train_reservation_pymcfm() {
		return "/reservation/train_reservation_pymcfm";
	}
	
	
	/*
	 * 회원 결제 페이지
	 */
	@RequestMapping(value="/train_reservation_member_stplcfmpym.do", method=RequestMethod.POST)
	public String train_reservation_member_stplcfmpym() {
		
		return "/reservation/train_reservation_member_stplcfmpym";
	}
	
	/*
	 * 비회원 결제 페이지
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
	 * 예매 좌석 선택 페이지
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
	 * 예매 시간 선택 페이지
	 */
	@RequestMapping(value="/train_reservation_alcnsrch.do", method=RequestMethod.GET)
	public String train_reservation_alcnsrch(HttpSession session,String startId ,String endId,String rtime) {
		 
		 ReservationVo rvo = new ReservationVo();
		
			/*
			 * System.out.println(startId); System.out.println(endId);
			 * System.out.println(rtime);
			 */
		 
		rvo.setStartId(startId);
		rvo.setEndId(endId);
		rvo.setRtime(rtime);
		
		session.setAttribute("rvo", rvo);
		
		return "/reservation/train_reservation_alcnsrch";
	}
	
	
	/*
	 * 예약 메인 페이지 
	 */
	@RequestMapping(value="/train_reservation_rotinf.do", method=RequestMethod.GET)
	public String train_reservation_rotinf() {
		
		return "/reservation/train_reservation_rotinf";
	}
}
