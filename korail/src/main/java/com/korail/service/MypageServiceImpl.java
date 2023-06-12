package com.korail.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.MypageDao;

@Service("mypageService")
public class MypageServiceImpl implements MypageService{

	@Autowired
	private MypageDao mypageDao;
	
	@Override
	public void cpassProc(HashMap<String, String> param) {
		mypageDao.passProc(param);
	}

}
