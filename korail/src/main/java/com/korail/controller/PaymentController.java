package com.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class PaymentController {

	/**
	 * Payment_histroy
	 * 
	 */
	@RequestMapping(value = "/pmyhis.do", method = RequestMethod.GET)
	public String pmyhis() {

		return "/payment_history/payment_history_view";
	}

	/**
	 * Pamyent_history_calender
	 * 
	 */

	@RequestMapping(value = "/paycal.do", method = RequestMethod.GET)
	public String paycal() {

		return "/payment_history/calender";
	}

	/**
	 * Payment_history_json
	 * 
	 */
	/*
	 * @RequestMapping(value="/plahis_json_data.do", method = RequestMethod.POST,
	 * produces="text/plain;charset=UTF-8")
	 * 
	 * @ResponseBody public String plahis_json_data(String per) { // Map<String,
	 * Integer> param = PaymentServiceImpl.getPageResult(per, "board"); //
	 * ArrayList<BoardVo> list // = boardService.getSelect(param.get("startCount"),
	 * param.get("endCount"));
	 * 
	 * JsonObject jlist = new JsonObject(); JsonArray jarray = new JsonArray();
	 * 
	 * for(Payment_historyVo phv : list) { JsonObject jobj = new JsonObject(); //{}
	 * jobj.addProperty("bid", phv.getBid()); //{rno:1}
	 * jobj.addProperty("PaymentDateTime", phv.getPaymentDateTime()); //{rno:1}
	 * jobj.addProperty("Category", phv.getCategory()); //{rno:1}
	 * jobj.addProperty("Route", phv.getRoute()); //{rno:1}
	 * jobj.addProperty("DispatchInfo", phv.getDispatchInfo()); //{rno:1}
	 * jobj.addProperty("Quantity", phv.getQuantity()); //{rno:1}
	 * jobj.addProperty("PaymentAmount", phv.getPaymentAmount()); //{rno:1}
	 * jobj.addProperty("DetailedInfo", phv.getDetailedInfo()); //{rno:1}
	 * 
	 * jarray.add(jobj); } jlist.add("jlist", jarray); jlist.addProperty("totals",
	 * param.get("dbCount")); jlist.addProperty("pageSize", param.get("pageSize"));
	 * jlist.addProperty("maxSize", param.get("maxSize")); jlist.addProperty("page",
	 * param.get("page"));
	 * 
	 * return new Gson().toJson(jlist); }
	 */
}
