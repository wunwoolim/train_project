package com.korail.controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.korail.dao.StationDao;
import com.korail.vo.StationVo;

@Controller
public class TrainController {
	
	@RequestMapping(value="/train_timetable.do", method=RequestMethod.GET)
	public String train_timetable() {
		return "train_info/train_timetable";
	}
	
	@RequestMapping(value="/train_route_info.do", method=RequestMethod.GET)
	public String train_route_info() {
		return "train_info/train_route_info";
	}
	
	@RequestMapping(value="/train_route_info_json.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String train_route_info_json(String category) {
		StationDao stationDao = new StationDao();
		
		StationVo stationVo = stationDao.select(category);
		ArrayList<String> stationList = stationDao.getStationList(category);
		
		JsonArray station_array = new JsonArray();
		for(String station: stationList) {
			JsonObject station_list = new JsonObject();
			station_list.addProperty("station", station);
			station_array.add(station_list);
		}
		JsonObject jlist = new JsonObject();
		JsonArray jarray_history = new JsonArray();	
		
		
		StringTokenizer st = new StringTokenizer(stationVo.getHistory(),"]");
		while(st.hasMoreTokens()){
			JsonObject json_history = new JsonObject();			
			json_history.addProperty("history", (String)st.nextElement());
			jarray_history.add(json_history);
		}
				
			JsonObject jobj = new JsonObject();
			jobj.addProperty("station", stationVo.getStation());
			jobj.addProperty("location", stationVo.getLocation());
			jobj.addProperty("sphone", stationVo.getSphone());
			jobj.addProperty("category", stationVo.getCategory());
			jobj.addProperty("info", stationVo.getInfo());
			jobj.addProperty("clink1", stationVo.getClink1());
			jobj.addProperty("clink2", stationVo.getClink2());
			jobj.addProperty("mlink", stationVo.getMlink());
			jobj.addProperty("plink", stationVo.getPlink());
			jobj.add("jhistory", jarray_history);
		
		jlist.add("jlist", jobj);
		jlist.add("station_list", station_array);
		
		/*System.out.println(jlist);*/
		
		return new Gson().toJson(jlist);			
		
	}
	
	/*
	 * @RequestMapping(value="/train_route_info_json_list.do",
	 * method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	 * 
	 * @ResponseBody public ModelAndView train_route_info_json_list(String category)
	 * { ModelAndView model = new ModelAndView(); StationDao stationDao = new
	 * StationDao(); ArrayList<StationVo> stationVo =
	 * stationDao.selectCategory(category);
	 * 
	 * }
	 */
	
}