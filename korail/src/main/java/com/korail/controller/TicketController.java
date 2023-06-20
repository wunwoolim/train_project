package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicketController {
	
	@RequestMapping(value="/info_payment.do", method=RequestMethod.GET)
	public String payment_info() {
		return "ticket_info/info_payment";
	}
	
	@RequestMapping(value="/info_refund.do", method=RequestMethod.GET)
	public String refund_info() {
		return "ticket_info/info_refund";
	}
	
	@RequestMapping(value="/info_reservation.do", method=RequestMethod.GET)
	public String reservation_info() {
		return "ticket_info/info_reservation";
	}

}

