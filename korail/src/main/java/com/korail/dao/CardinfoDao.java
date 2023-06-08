package com.korail.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.CardinfoVo;

@Repository
public class CardinfoDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insert(CardinfoVo cardVo) {
		return sqlSession.insert("mapper.card.payment", cardVo);
	}
}
