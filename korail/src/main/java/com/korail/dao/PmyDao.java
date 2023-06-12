package com.korail.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.OrderVo;

@Repository
public class PmyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<OrderVo> check(HashMap<String, String> param) {
	    List<OrderVo> result = sqlSession.selectList("mapper.pmy.check", param);
//	    System.out.println("Dao Result: " + result.toString());
	    return result;
	}

}
