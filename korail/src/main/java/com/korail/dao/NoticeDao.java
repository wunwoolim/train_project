package com.korail.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao implements MyktxDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.updateHits", nid);
	}
	
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
	}

	@Override
	public int insert(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> select(int startCount, int endCount) {
		// TODO Auto-generated method stub
		return null;
	}
}
