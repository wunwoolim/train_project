package com.korail.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.PmyDao;
import com.korail.vo.OrderVo;

@Service("pmyService")
public class PmyhisServiceImpl implements PmyhisService{

	@Autowired
	private PmyDao pmyDao;
	
	@Override
	public ArrayList<OrderVo> getSelect(HashMap<String, String> param) {
		ArrayList<OrderVo> list = (ArrayList<OrderVo>)pmyDao.check(param);
//		System.out.println("Impl list : " + list);
		return list;
	}

}
