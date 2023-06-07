package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SitemapController {

	@RequestMapping(value = "/sitemap.do", method = RequestMethod.GET)
	public String sitemap() {

		return "/sitemap/sitemap";
	}
}
