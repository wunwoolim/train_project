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
	 *  예매된 좌석 출력
	 */
	public List<SeatNumberVo> seatnum(ReservationVo rvo){
		
		return sqlSession.selectList("mapper.order.seatnum", rvo);
	}

	/*
	 *  예매된 좌석 출력 - 예매 변경
	 */
	public List<SeatNumberVo> seatnumUp(UpdateVo uvo){
		
		return sqlSession.selectList("mapper.order.seatnumUp", uvo);
	}
	
	/**
	 * 예매내역 출력
	 */
	public ArrayList<OrderVo> select(OrderVo orderVo) {
		
		List<OrderVo> list = sqlSession.selectList("mapper.order.select", orderVo);
		return (ArrayList<OrderVo>)list;

	}
	
	/**
	 * 카드번호 조회
	 */
	public int selectCardnum(String cardnum) {
		return sqlSession.selectOne("mapper.order.selectcard", cardnum);
	}
	
	/**
	 * 예매 취소하기
	 */
	public int update(String reservnum) {
		return sqlSession.update("mapper.order.cancel", reservnum);
	}

	/**
	 * 영수증, 홈티켓 출력, 예매 변경
	 */
	public OrderVo selected(String reservnum) {

		return sqlSession.selectOne("mapper.order.selected",reservnum);
	}

	/**
	 * 예매내역 전체 출력
	 */
	public List<Object> orderselect(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.order.orderselect", param);
		
	}

	/**
	 * 예매처리
	 */
	public int insert(OrderVo orderVo) {

		return sqlSession.insert("mapper.order.payment", orderVo);
	}

	/**
	 * 예매처리
	 */
	public int updatePayment(OrderVo orderVo) {

		return sqlSession.update("mapper.order.updatePayment", orderVo);
	}

}
