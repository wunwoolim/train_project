package com.korail.service;

import com.korail.vo.MemberVo;

public interface MemberService {
	public int getLoginResult(MemberVo memberVo);
	public int getIdCheckResult(String id);
	public int getJoinResult(MemberVo memberVo); 	
	/* public ArrayList<MemberVo> getList(int startCount, int endCount); */
	/* public int getTotalRowCount(); */
}