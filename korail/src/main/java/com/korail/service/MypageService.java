package com.korail.service;

import java.util.HashMap;
import java.util.List;

import com.korail.vo.MemberVo;

public interface MypageService {
	public int getCount(String userId);
	public int getPassupdate(HashMap<String, String> param);
	public int getWithresult(String id);
	public List<MemberVo> getInfo(String userId);
	public int getPnumberUpdate(HashMap<String, String> param);
}
