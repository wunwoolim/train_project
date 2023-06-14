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
	 * reservation_main.do - 예매내역
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
	        // userId 값이 없는 경우 로그인 페이지로 리다이렉트
	        model.setViewName("redirect:/login2.do");
	        return model;
	    }
	    
	    // 로그인한 사용자의 id와 cardnum을 설정하여 조회
	    orderVo.setId(id);
	    orderVo.setCardnum(cardnum);
	    
		ArrayList<OrderVo> orderList = orderService.getSelect(orderVo);
	    
		System.out.println(orderList.get(0).getCardnum());
		
		model.addObject("orderList", orderList);
	    model.setViewName("/reservationlist/reservation_main");
	    return model;
	}
	
	/**
	 * reservCancel_check.do - 예매취소 처리
	 */
	@RequestMapping(value="/reservCancel_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String reservCancel_check(String reservnum) {	//반드시 문자열로 넘겨야 하기때문에 타입은 String
		return orderService.getCancelResult(reservnum); 
	}
	
	
	/**
	 * reservation_receipt.do - 영수증 폼
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
	 * reservation_hometicket.do - 홈티켓 폼
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
	 * admin_trainlist.do - ktx 리스트 - 관리자페이지 
	 */
	@RequestMapping(value="/admin_trainlist.do", method=RequestMethod.GET)
	public String admin_trainlist() {
		
		return "/admin/admin_trainlist";
	}
	
	
	/**
	 * admin_reservationlist.do - 예매 전체 리스트 - 관리자페이지 
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
	 * admin_cancellist.do - 예매취소 전체 리스트 - 관리자페이지 
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
	 * reservation_update.do - 예매 변경 1번째 페이지
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
	 * reservation_updatetime.do - 예매변경 2번째 페이지 (배차조회)
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
	 * reservation_updatechair.do - 예매변경 3번째 페이지 - 좌석선택
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
	 *   reservation_updatepay.do - 예매변경 4번째 페이지 - 비회원 결제 
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
	 * reservation_update_proc - 마지막 - 예매변경 처리
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
			//에러페이지
		}
		return viewName;
	}
	
	
	
	
	
	/**
	 * admin_main.do - 관리자 메인
	 */
	@RequestMapping(value="/admin_main.do", method=RequestMethod.GET)
	public String admin_main() {
		
		return "/admin/admin_main";
	} 
	
	
	
	
	/**
	 * cardnum_check_proc.do - 로그인2 카드번호로 조회하기 처리
	 */
	 @RequestMapping(value="/cardnum_check_proc.do", method=RequestMethod.POST)
	 public ModelAndView cardnum_check_proc(String cardnum, String userId, HttpSession session) {
		 ModelAndView model = new ModelAndView();
		 int result = orderService.getCardnum(cardnum);
		 
		 if (result == 1) {
		        // 카드번호 조회 성공 시 세션에 사용자 정보 저장
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
