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
	 * loginCheck - �α��� üũ
	 */
	public int loginCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.login", memberVo);	
	}
	
	/**
	 * ���̵� üũ - �ߺ�üũ
	 */
	public int joincheck(String id) {
		System.out.println("dao------->>"+id);
		return sqlSession.selectOne("mapper.member.joincheck", id);
	}
		
	
	/**
	 * insert - ȸ������
	 */
	
	  public int insert(MemberVo memberVo) {
		  return sqlSession.insert("mapper.member.join", memberVo);
	 
	  }
	 

}