package com.korail.service;

import java.util.ArrayList;

import com.korail.vo.MemberVo;
import com.korail.vo.SessionVo;

public interface MemberService {
	public SessionVo getLoginResult(MemberVo memberVo);
	public int getIdCheckResult(String id);
	public int getJoinResult(MemberVo memberVo); 	
	 public ArrayList<MemberVo> getList(int startCount, int endCount); 
	public ArrayList<MemberVo> getList(int startCount, int endCount, String category, String cvalue);
 	public MemberVo getFindIdResult(String email);
 	public MemberVo getFindPassResult(String email);
 	public int getEmailCheckResult(String email);
		/* public int getTotalRowCount(); */
}