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
	 * ȸ������ �˻�
	 */
	
	public List<MemberVo> memberSelectAll(MemberVo membervo) {
		return sqlSession.selectList("member-mapper.memberSelectAll", membervo);
	}
	
	
	/**
	 * select - ȸ������Ʈ
	 */
	@Override
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.member.list",param);
	}
		
	
	
	
	
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
	
	public int insert(Object memberVo) {
		  return sqlSession.insert("mapper.member.join", memberVo);
	 
	  }
	 

}