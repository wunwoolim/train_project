package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderContorller {
	@RequestMapping(value = "/header_util.do", method = RequestMethod.GET)
	public String header_util() {

		return "/header/header_util";
	}
	@RequestMapping(value = "/header_mypage_receipt.do", method = RequestMethod.GET)
	public String header_mypage_receipt() {
		
		return "/header/header_mypage_receipt";
	}

	@RequestMapping(value = "/header_cart_list.do", method = RequestMethod.GET)
	public String header_cart_list() {

		return "/header/header_cart_list";
	}

	@RequestMapping(value = "/header_mypage.do", method = RequestMethod.GET)
	public String header_mypage() {

		return "/header/header_mypage";
	}

	@RequestMapping(value = "/header_reservation.do", method = RequestMethod.GET)
	public String header_reservation() {

		return "/header/header_reservation";
	}

	@RequestMapping(value = "/header_payment.do", method = RequestMethod.GET)
	public String header_payment() {

		return "/header/header_payment";
	}

	@RequestMapping(value = "/header_sitemap.do", method = RequestMethod.GET)
	public String header_sitemap() {

		return "/header/header_sitemap";
	}

	@RequestMapping(value = "/header_sreser.do", method = RequestMethod.GET)
	public String header_sreser() {

		return "/header/header_sreser";
	}

}
