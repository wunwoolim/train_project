package com.korail.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.OrderVo;
import com.korail.vo.ReservationVo;
import com.korail.vo.SeatNumberVo;
import com.korail.vo.UpdateVo;

@Repository
public class OrderDao extends DBConn {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*
	 *  ���ŵ� �¼� ���
	 */
	public List<SeatNumberVo> seatnum(ReservationVo rvo){
		
		return sqlSession.selectList("mapper.order.seatnum", rvo);
	}

	/*
	 *  ���ŵ� �¼� ��� - ���� ����
	 */
	public List<SeatNumberVo> seatnumUp(UpdateVo uvo){
		
		return sqlSession.selectList("mapper.order.seatnumUp", uvo);
	}
	
	/**
	 * ���ų��� ���
	 */
	public ArrayList<OrderVo> select(OrderVo orderVo) {
		
		List<OrderVo> list = sqlSession.selectList("mapper.order.select", orderVo);
		return (ArrayList<OrderVo>)list;

	}
	
	/**
	 * ī���ȣ ��ȸ
	 */
	public int selectCardnum(String cardnum) {
		return sqlSession.selectOne("mapper.order.selectcard", cardnum);
	}
	
	/**
	 * ���� ����ϱ�
	 */
	public int update(String reservnum) {
		return sqlSession.update("mapper.order.cancel", reservnum);
	}

	/**
	 * ������, ȨƼ�� ���, ���� ����
	 */
	public OrderVo selected(String reservnum) {

		return sqlSession.selectOne("mapper.order.selected",reservnum);
	}

	/**
	 * ���ų��� ��ü ���
	 */
	public List<Object> orderselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.order.orderselect", param);
		
	}

	/**
	 * ����ó��
	 */
	public int insert(OrderVo orderVo) {

		return sqlSession.insert("mapper.order.payment", orderVo);
	}

	/**
	 * ����ó��
	 */
	public int updatePayment(OrderVo orderVo) {

		return sqlSession.update("mapper.order.updatePayment", orderVo);
	}

}
