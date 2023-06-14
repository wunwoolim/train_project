package com.korail.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.MypageDao;
import com.korail.vo.MemberVo;

@Service("mypageService")
public class MypageServiceImpl implements MypageService {

	@Autowired
	private MypageDao mypageDao;

	@Override
	public int getCount(String userId) {
		return mypageDao.count(userId);
	}

	@Override
	public List<MemberVo> getInfo(String userId) {
		return mypageDao.getInfo(userId);
	}

	@Override
	public int getPassupdate(HashMap<String, String> param) {
		return mypageDao.getPassupdate(param);
	}

	@Override
	public int getPnumberUpdate(HashMap<String, String> param) {
		return mypageDao.getPnumberUpdate(param);
	}

	@Override
	public int getWithresult(String id) {
		return mypageDao.getWithresult(id);
	}

}
