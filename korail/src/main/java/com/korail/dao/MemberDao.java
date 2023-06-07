package com.korail.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.MemberVo;

@Repository
public class MemberDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	
	
	
	/**
	 * loginCheck - 로그인 체크
	 */
	public int loginCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.login", memberVo);	
	}
	
	/**
	 * 아이디 체크 - 중복체크
	 */
	public int joincheck(String id) {
		System.out.println("dao------->>"+id);
		return sqlSession.selectOne("mapper.member.joincheck", id);
	}
		
	
	/**
	 * insert - 회원가입
	 */
	
	  public int insert(MemberVo memberVo) {
		  return sqlSession.insert("mapper.member.join", memberVo);
	 
	  }
	 

}