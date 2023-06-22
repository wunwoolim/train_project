package com.korail.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.MemberVo;
import com.korail.vo.SessionVo;

@Repository
public class MemberDao implements MyktxDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	
	public MemberVo findID(String email) {
		return sqlSession.selectOne("mapper.member.findId",email);
	}
	
	
	
	public MemberVo findPASS(String email) {
		return sqlSession.selectOne("mapper.member.findPass",email);
	}
	
	
	
	
	
	/**
	 * select - 회원리스트
	 */
	public List<Object> select(int startCount, int endCount, String category, String cvalue) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		param.put("category", category);
		param.put("cvalue", cvalue);
		
		return sqlSession.selectList("mapper.member.search_list",param);
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
	public SessionVo loginCheck(MemberVo memberVo) {
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
	
	/**
	 * 회원가입 이메일 체크 - 중복체크
	 */
	
	public int joinemailcheck(String email) {
		System.out.println("dao------->>"+email);
		return sqlSession.selectOne("mapper.member.emailcheck", email);
	}
	};
	
	
	
	 

