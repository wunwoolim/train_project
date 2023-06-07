package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicketController {
	
	@RequestMapping(value="/payment_info.do", method=RequestMethod.GET)
	public String payment_info() {
		return "ticket_info/payment_info";
	}
	
	@RequestMapping(value="/refund_info.do", method=RequestMethod.GET)
	public String refund_info() {
		return "ticket_info/refund_info";
	}
	
	@RequestMapping(value="/reservation_info.do", method=RequestMethod.GET)
	public String reservation_info() {
		return "ticket_info/reservation_info";
	}

}

