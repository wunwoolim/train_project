package com.korail.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.korail.vo.OrderVo;

public interface PmyhisService {
	
	ArrayList<OrderVo> getSelect(HashMap<String, String> param);
}
