package com.korail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.MemberDao;
import com.korail.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements  MemberService{

	@Autowired
	private MemberDao memberDao;
	
	/* @Override */
	/*
	 * public int getTotalRowCount() { MemberDao memberDao = new MemberDao(); return
	 * memberDao.totalRowCount(); }
	 */
	
	/*
	 * @Override public ArrayList<MemberVo> getList(int startCount, int endCount){
	 * //MemberDao memberDao = new MemberDao(); return memberDao.select(startCount,
	 * endCount); }
	 */
	
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
	 public int getLoginResult(MemberVo memberVo) {
		 return memberDao.loginCheck(memberVo); 
	 }
}
