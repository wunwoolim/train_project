package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sreservation {

	@RequestMapping(value = "/s_reservation.do", method = RequestMethod.GET)
	public String sitemap() {

		return "/specal_reservation/s_reservation";
	}
}
