package com.korail.controller;

import java.util.ArrayList;
import java.util.HashMap;

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
import com.korail.service.OrderService;
import com.korail.service.PmyhisServiceImpl;
import com.korail.vo.OrderVo;
import com.korail.vo.SessionVo;

@Controller
public class PaymentController {
	
	@Autowired
	private PmyhisServiceImpl pmyService;
	
	@Autowired
	private OrderService orderService;
	
//    @Autowired
//    public FileController (ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
	
	/**
	 * Payment_histroy
	 * 
	 */
	@RequestMapping(value = "/pmyhis.do", method = RequestMethod.GET)
	public String pmyhis() {

		return "/payment_history/payment_history_view";
	}
	
	/**
	 * myreservation_receipt.do - ������ ��
	 */
	@RequestMapping(value="/myreservation_receipt.do", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reservation_receipt(String reservnum) {
		ModelAndView model = new ModelAndView();
		
		OrderVo orderVo = orderService.getSelected(reservnum);
		
		model.addObject("ovo", orderVo);
		model.setViewName("/payment_history/payment_receipt");

		return model;
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
	@RequestMapping(value="/paypment_json_data.do", method = RequestMethod.POST,
			produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String plahis_json_data(HttpSession session, String date1Str, String date2Str, String checked) {
		//Payment_historyVo payVo =  pymService.getPageResult(bid);
		HashMap<String, String> param = new HashMap<String, String>();
		
		SessionVo svo = (SessionVo) session.getAttribute("svo");
		String id = svo.getId();

		param.put("id", id);
		param.put("date1", date1Str);
		param.put("date2", date2Str);
		param.put("status", checked);
		ArrayList<OrderVo> list 
		= pmyService.getSelect(param);
		
	JsonObject jlist = new JsonObject();
	JsonArray jarray = new JsonArray();
	
	for(OrderVo phv : list) {
		JsonObject jobj = new JsonObject();  //{}
		jobj.addProperty("rdate", phv.getRdate()); //{rno:1}
		jobj.addProperty("sstation", phv.getSstation());
		jobj.addProperty("dstation", phv.getDstation());
		jobj.addProperty("stime", phv.getStime());
		jobj.addProperty("price", phv.getPrice());
		jobj.addProperty("qty", phv.getTicketqty());
		jobj.addProperty("time", phv.getDepPlandTime());
		jobj.addProperty("status", phv.getCancel());
		jobj.addProperty("rnum", phv.getReservnum());
		jarray.add(jobj);
	}
	jlist.add("jlist", jarray);	
//	System.out.println(jlist.toString());
	return new Gson().toJson(jlist);
	}
}
