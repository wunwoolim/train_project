package com.korail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.MemberDao;
import com.korail.vo.MemberVo;
import com.korail.vo.SessionVo;

@Service("memberService")
public class MemberServiceImpl implements  MemberService{

	@Autowired
	private MemberDao memberDao;
	/*
	 * @Override public int getTotalRowCount() { MemberDao memberDao = new
	 * MemberDao(); return memberDao.totalRowCount(); }
	 */
	
	@Override
	public ArrayList<MemberVo> getList(int startCount, int endCount, String category, String cvalue){
		ArrayList<MemberVo> rlist = new ArrayList<MemberVo>();
		List<Object> list = memberDao.select(startCount, endCount, category , cvalue);
		for(Object obj : list) {
			MemberVo memberVo = (MemberVo)obj;
			rlist.add(memberVo);
		}
		return rlist;
	}

	@Override
	public ArrayList<MemberVo> getList(int startCount, int endCount){
		ArrayList<MemberVo> rlist = new ArrayList<MemberVo>();
		List<Object> list = memberDao.select(startCount, endCount);
		for(Object obj : list) {
			MemberVo memberVo = (MemberVo)obj;
			rlist.add(memberVo);
		}
		return rlist;
	}
	
	  @Override public int getJoinResult(MemberVo memberVo) { // MemberDao
		  return memberDao.insert(memberVo); 
		  }
	 
	
	@Override
	public int getIdCheckResult(String id) {
		int result = memberDao.joincheck(id);	
		System.out.println("result -->" +result);
		return result;
	}	
	
	 @Override 
	 public SessionVo getLoginResult(MemberVo memberVo) {
		 return memberDao.loginCheck(memberVo); 
	 }
	 
	 @Override
	 	public MemberVo getFindIdResult(String email) {
		 return memberDao.findID(email);
	 }
	 
	 @Override
	 public MemberVo getFindPassResult(String email) {
		 return memberDao.findPASS(email);
	 }
	 
	 
	 @Override
	 public int getEmailCheckResult(String email) {
		 	int result = memberDao.joinemailcheck(email);	
			System.out.println("result -->" +result);
			return result;
		}	
	 
}
	 
