package com.korail.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.MemberVo;

@Repository
public class MemberDao implements MyktxDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/**
	 * 회원관리 검색
	 */
	
	public List<MemberVo> memberSelectAll(MemberVo membervo) {
		return sqlSession.selectList("member-mapper.memberSelectAll", membervo);
	}
	
	
	/**
	 * select - 회원리스트
	 */
	@Override
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.member.list",param);
	}
		
	
	
	
	
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
	
	public int insert(Object memberVo) {
		  return sqlSession.insert("mapper.member.join", memberVo);
	 
	  }
	 

}