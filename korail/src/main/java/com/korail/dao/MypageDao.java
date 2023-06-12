package com.korail.dao;


import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MypageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void passProc(HashMap<String, String> param) {
		sqlSession.update("mapper.mypage.pass", param);
	}

}
