package com.korail.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.korail.service.CardinfoServiceImpl;
import com.korail.service.OrderService;
import com.korail.vo.CardinfoVo;
import com.korail.vo.OrderVo;
import com.korail.vo.ReservationVo;


@Controller
public class ReservationController {
	@Autowired
	private OrderService orderService;
	
	@Autowired 
	private CardinfoServiceImpl cardService;
	/*
	 * 결제 완료 페이지 
	 */
	@RequestMapping(value="/train_reservation_pymcfm.do", method=RequestMethod.POST)
	public ModelAndView train_reservation_pymcfm(HttpSession session, OrderVo orderVo, CardinfoVo cardVo) {
		ModelAndView model = new ModelAndView();
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		UUID uuid = UUID.randomUUID();
		/*
		 * System.out.println(rvo.getDepplacename());
		 * System.out.println(rvo.getRtime()); System.out.println(rvo.getStart_date());
		 * System.out.println(rvo.getEnd_date());
		 * System.out.println(rvo.getArrplacename());
		 * System.out.println(rvo.getSeatNum()); System.out.println(rvo.getStartId());
		 * System.out.println(rvo.getEndId());
		 * System.out.println(Integer.parseInt(rvo.getAdultcharge()));
		 * System.out.println(Integer.parseInt(rvo.getTrainno()));
		 * System.out.println(Integer.parseInt(rvo.getTicketQty()));
		 */
		System.out.println(cardVo.getBirthday());
		System.out.println(cardVo.getCardcomp());
		System.out.println(cardVo.getCardnum());
		//System.out.println(cardVo.getRecognizenum()); //승인번호
		cardVo.setRecognizenum(uuid.toString().replaceAll("-", "").substring(0, 10));
		
		orderVo.setSstation(rvo.getDepplacename());
		orderVo.setStime(rvo.getStart_date());
		orderVo.setDtime(rvo.getEnd_date());
		orderVo.setDstation(rvo.getArrplacename());
		orderVo.setReservnum(uuid.toString().substring(0, 8));  //예매 번호
		orderVo.setChairnum(rvo.getSeatNum());
		/* orderVo.setId(); */
		orderVo.setDepPlaceId(rvo.getStartId());
		orderVo.setArrPlaceId(rvo.getEndId());
		orderVo.setDepPlandTime(rvo.getRtimes());
		orderVo.setCardnum(cardVo.getCardnum());
		orderVo.setPrice(Integer.parseInt(rvo.getAdultcharge()));
		orderVo.setTrainnum(Integer.parseInt(rvo.getTrainno()));
		orderVo.setTicketqty(Integer.parseInt(rvo.getTicketQty()));
		
		
		
		orderService.getPayment(orderVo);
		cardService.getPayment(cardVo);
		
		
		System.out.println(cardVo.getRecognizenum());
		
		model.setViewName("/reservation/train_reservation_pymcfm");
		
		
		return model;
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
	
	@RequestMapping(value="/main_train.do", method=RequestMethod.GET)
	public String main_train() {
		
		return "main_train";
	}
}
