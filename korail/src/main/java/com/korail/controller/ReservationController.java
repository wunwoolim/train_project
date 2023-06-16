package com.korail.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.korail.service.CardinfoServiceImpl;
import com.korail.service.OrderService;
import com.korail.vo.CardinfoVo;
import com.korail.vo.OrderVo;
import com.korail.vo.ReservationVo;
import com.korail.vo.SeatNumberVo;


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
	public ModelAndView train_reservation_pymcfm(HttpSession session, OrderVo orderVo, CardinfoVo cardVo,ReservationVo reservationVo) {
		ModelAndView model = new ModelAndView();
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		UUID uuid = UUID.randomUUID();
	
		
		//System.out.println(cardVo.getRecognizenum()); //승인번호
		
		cardVo.setRecognizenum(uuid.toString().replaceAll("-", "").substring(0, 10));
		
		orderVo.setSstation(rvo.getDepplacename());
		orderVo.setStime(rvo.getStart_date());
		orderVo.setDtime(rvo.getEnd_date());
		orderVo.setDstation(rvo.getArrplacename());
		orderVo.setReservnum(uuid.toString().substring(0, 8));  //예매 번호
		orderVo.setChairnum(rvo.getSeatNum());
		orderVo.setId(rvo.getId());
		orderVo.setDepPlaceId(rvo.getStartId());
		orderVo.setArrPlaceId(rvo.getEndId());
		orderVo.setDepPlandTime(rvo.getRtimes());
		orderVo.setCardnum(cardVo.getCardnum());
		orderVo.setPrice(Integer.parseInt(rvo.getAdultcharge()));
		orderVo.setTrainnum(Integer.parseInt(rvo.getTrainno()));
		orderVo.setTicketqty(Integer.parseInt(rvo.getTicketQty()));
		orderVo.setEmail(reservationVo.getEmail());
		
		System.out.println("reservationVo.getEmail()-->" + reservationVo.getEmail());
		orderService.getPayment(orderVo);
		cardService.getPayment(cardVo);
		
		
		
		model.setViewName("/reservation/train_reservation_pymcfm");
		
		
		return model;
	}
	
	
	
	/*
	 * 회원 결제 페이지
	 */
	@RequestMapping(value="/train_reservation_stplcfmpym1.do", method=RequestMethod.GET)
	public String train_reservation_stplcfmpym1(HttpSession session) {
		
		
		return "/reservation/train_reservation_stplcfmpym";
	}
	
	/*
	 * 비회원 결제 페이지
	 */
	@RequestMapping(value="/train_reservation_stplcfmpym2.do", method=RequestMethod.POST)
	public String train_reservation_stplcfmpym2(ReservationVo reservationVo, HttpSession session) {
		//ModelAndView model = new ModelAndView();
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		
		rvo.setSeatNum(reservationVo.getSeatNum2());
		rvo.setTicketQty(reservationVo.getTicketQty2());
		rvo.setId("GUEST");
		
	
		return "/reservation/train_reservation_stplcfmpym";
	}
	
	/*
	 * 
	 */
	@RequestMapping(value="/stplcfmpym.do", method=RequestMethod.GET)
	public String stplcfmpym(String seatNum, String ticketQty, String id ,HttpSession session) {
		
		System.out.println("seatNum-->"+seatNum);
		System.out.println("ticketQty-->"+ticketQty);
		System.out.println("id-->"+id);
		
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		
		rvo.setSeatNum(seatNum);
		rvo.setTicketQty(ticketQty);
		rvo.setId(id);
		//"redirect:/train_reservation_stplcfmpym1.do"
		return "redirect:/train_reservation_stplcfmpym1.do";
	}
	
	
	/*
	 * 예매 좌석 선택 페이지
	 */
	@RequestMapping(value="/train_reservation_satschc.do",method=RequestMethod.POST)
	public String train_reservation_satschc(ReservationVo reservationVo, HttpSession session,
			String depplacename, String arrplacename, String start_date, String end_date, String traingradename, String trainno, String adultcharge, String rtimes) {
		
		
		
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		rvo.setDepplacename(depplacename);
		rvo.setArrplacename(arrplacename);
		rvo.setStart_date(start_date);
		rvo.setEnd_date(end_date);
		rvo.setTraingradename(traingradename);
		rvo.setTrainno(trainno);
		rvo.setAdultcharge(adultcharge);
		rvo.setRtimes(rtimes);
		
		
		return "/reservation/train_reservation_satschc";
	}
	
	/*
	 * 예매 좌석 선택 페이지 json
	 */
	@RequestMapping(value="/train_reservation_satschc_json.do",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String train_reservation_satschc_json(String trnumber, HttpSession session) {
		
		ReservationVo rvo = (ReservationVo)session.getAttribute("rvo");
		
		rvo.setTrnumber(trnumber);
		ArrayList<SeatNumberVo> list  = (ArrayList<SeatNumberVo>)orderService.getSeatnum(rvo);
		
		
		JsonArray seatList = new JsonArray(); //배열로 만들애
		JsonObject slist = new JsonObject();
		
		for(SeatNumberVo seatvo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("seat", seatvo.getSeatnum());
			seatList.add(jobj);
		}
		slist.add("seatList", seatList);
		
		
		return new Gson().toJson(slist);
	}
	
	/*
	 * 예매 시간 선택 페이지
	 */
	@RequestMapping(value="/train_reservation_alcnsrch.do", method=RequestMethod.GET)
	public String train_reservation_alcnsrch(HttpSession session,String startId ,String endId,String rtime, String start_add,String end_add) {
		 
		 ReservationVo rvo = new ReservationVo();
		
		 
		rvo.setStartId(startId);
		rvo.setEndId(endId);
		rvo.setRtime(rtime);
		rvo.setStart_add(start_add);
		rvo.setEnd_add(end_add);
		
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
