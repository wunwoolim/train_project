package com.korail.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.OrderVo;

@Repository
public class OrderDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;	
	
	/**
	 * 예매내역 출력
	 */
	public ArrayList<OrderVo> select(){
		
		ArrayList<OrderVo> orderList = new ArrayList<OrderVo>();
		
		String sql = "SELECT sstation, depPlandTime, stime, dstation, price, reservnum, trainnum, chairnum, cancel, depPlaceId, arrPlaceId  FROM KTX_ORDER where id='HONG1234'";
		
		getPreparedStatement(sql);
		
		try {
			/* pstmt.setString(1, id); */
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				OrderVo orderVo = new OrderVo();
				
				 orderVo.setSstation(rs.getString(1)); 
				 orderVo.setDepPlandTime(rs.getString(2));
				 orderVo.setStime(rs.getString(3));
				 orderVo.setDstation(rs.getString(4));
				 orderVo.setPrice(rs.getInt(5));
				 orderVo.setReservnum(rs.getString(6));
				 orderVo.setTrainnum(rs.getInt(7));
				 orderVo.setChairnum(rs.getString(8));
				 orderVo.setCancel(rs.getInt(9));
				 orderVo.setDepPlaceId(rs.getString(10));
				 orderVo.setArrPlaceId(rs.getString(11));
				 
				 orderList.add(orderVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	/**
	 * 예매 취소하기
	 */
	public int update(String reservnum) {
		int result = 0;
		
		String sql = "update ktx_order set cancel=1 where reservnum=? "; 
		getPreparedStatement(sql);
		
		try {
			
			pstmt.setString(1, reservnum);		
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	/**
	 * 영수증, 홈티켓 출력, 예매 변경
	 */
	public OrderVo selected(String reservnum){
		
		OrderVo orderVo = new OrderVo();
		
		String sql = "SELECT sstation, depPlandTime, stime, dstation, price, reservnum, trainnum, chairnum, cancel, depPlaceId, arrPlaceId  FROM KTX_ORDER where reservnum=? ";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, reservnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				orderVo.setSstation(rs.getString(1)); 
				 orderVo.setDepPlandTime(rs.getString(2));
				 orderVo.setStime(rs.getString(3));
				 orderVo.setDstation(rs.getString(4));
				 orderVo.setPrice(rs.getInt(5));
				 orderVo.setReservnum(rs.getString(6));
				 orderVo.setTrainnum(rs.getInt(7));
				 orderVo.setChairnum(rs.getString(8));
				 orderVo.setCancel(rs.getInt(9));
				 orderVo.setDepPlaceId(rs.getString(10));
				 orderVo.setArrPlaceId(rs.getString(11));
				 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderVo;
	}
	
	
	/**
	 * 예매내역 출력
	 */
	public ArrayList<OrderVo> orderselect(){
		
		ArrayList<OrderVo> orderList = new ArrayList<OrderVo>();
		
		String sql = "SELECT sstation, rdate, depPlandTime, stime, dtime, dstation, price, reservnum, trainnum, chairnum, id, cardnum,cancel FROM KTX_ORDER order by rdate";
		
		getPreparedStatement(sql);
		
		try {
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				OrderVo orderVo = new OrderVo();
				
				 orderVo.setSstation(rs.getString(1)); 
				 orderVo.setRdate(rs.getString(2)); 
				 orderVo.setDepPlandTime(rs.getString(3));
				 orderVo.setStime(rs.getString(4));
				 orderVo.setDtime(rs.getString(5));
				 orderVo.setDstation(rs.getString(6));
				 orderVo.setPrice(rs.getInt(7));
				 orderVo.setReservnum(rs.getString(8));
				 orderVo.setTrainnum(rs.getInt(9));
				 orderVo.setChairnum(rs.getString(10));
				 orderVo.setId(rs.getString(11));
				 orderVo.setCardnum(rs.getString(12));
				 orderVo.setCancel(rs.getInt(13));
				 
				 orderList.add(orderVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	
	
	
	
	public int insert(OrderVo orderVo) {
		
		return sqlSession.insert("mapper.order.payment", orderVo);
	}
	
	
}
