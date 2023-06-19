package com.korail.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 전체 로우 카운트 - 페이징 처리
	 * @return
	 */
	public int totalRowCount(String sname, String category, String cvalue) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("sname", sname);
		param.put("category", category);
		param.put("cvalue", cvalue);
		
		return sqlSession.selectOne("mapper.page.count", param);		
	}
	
	public int totalRowCount(String sname) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("sname", sname);
		
		return sqlSession.selectOne("mapper.page.noticecount", param);		
	}
	
	public int noticeTotalRowCount(String category, String cvalue) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("category", category);
		param.put("cvalue", cvalue);
		
		return sqlSession.selectOne("mapper.page.noticecount", param);		
	}
}