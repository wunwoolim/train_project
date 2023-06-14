package com.korail.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.MemberVo;

@Repository
public class MypageDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

//	public void passProc(HashMap<String, String> param) {
//		sqlSession.update("mapper.mypage.pass", param);
//	}

	public int count(String userId) {
		return sqlSession.selectOne("mapper.mypage.count", userId);
	}

	public List<MemberVo> getInfo(String userId) {
		return sqlSession.selectList("mapper.mypage.mail", userId);
	}

	public int getPassupdate(Map<String, String> param) {
		int result = sqlSession.update("mapper.mypage.pass", param);
		return result;
	}

	public int getPnumberUpdate(HashMap<String, String> param) {
		int result = sqlSession.update("mapper.mypage.pnumber", param);
		return result;
	}
	public int getWithresult(String id) {
		int result = sqlSession.update("mapper.mypage.with", id);
		return result;
	}
}
