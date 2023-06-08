package com.korail.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao implements MyktxDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
}
