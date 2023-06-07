package com.korail.dao;

import java.util.ArrayList;

import com.korail.vo.OrderVo;

public class OrderDao extends DBConn{
	
	/**
	 * 예매내역 출력
	 */
	public ArrayList<OrderVo> select(){
		
		ArrayList<OrderVo> orderList = new ArrayList<OrderVo>();
		
		String sql = "SELECT sstation, depPlandTime, stime, runtime, dstation, price, reservnum, trainnum, charnum, cancel FROM KTX_ORDER where mid='HONG1234'";
		
		getPreparedStatement(sql);
		
		try {
			/* pstmt.setString(1, mid); */
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				OrderVo orderVo = new OrderVo();
				
				 orderVo.setSstation(rs.getString(1)); 
				 orderVo.setDepPlandTime(rs.getString(2));
				 orderVo.setStime(rs.getString(3));
				 orderVo.setRuntime(rs.getString(4));
				 orderVo.setDstation(rs.getString(5));
				 orderVo.setPrice(rs.getInt(6));
				 orderVo.setReservnum(rs.getString(7));
				 orderVo.setTrainnum(rs.getInt(8));
				 orderVo.setCharnum(rs.getString(9));
				 orderVo.setCancel(rs.getInt(10));
				 
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
	 * 영수증, 홈티켓 출력
	 */
	public OrderVo selected(String reservnum){
		
		OrderVo orderVo = new OrderVo();
		
		String sql = "SELECT sstation, depPlandTime, stime, runtime, dstation, price, reservnum, trainnum, charnum, cancel FROM KTX_ORDER where reservnum=? ";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, reservnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				 orderVo.setSstation(rs.getString(1)); 
				 orderVo.setDepPlandTime(rs.getString(2));
				 orderVo.setStime(rs.getString(3));
				 orderVo.setRuntime(rs.getString(4));
				 orderVo.setDstation(rs.getString(5));
				 orderVo.setPrice(rs.getInt(6));
				 orderVo.setReservnum(rs.getString(7));
				 orderVo.setTrainnum(rs.getInt(8));
				 orderVo.setCharnum(rs.getString(9));
				 orderVo.setCancel(rs.getInt(10));
				 
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
		
		String sql = "SELECT sstation, depPlandTime, stime, runtime, dstation, price, reservnum, trainnum, charnum, mid, cancel FROM KTX_ORDER";
		
		getPreparedStatement(sql);
		
		try {
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				OrderVo orderVo = new OrderVo();
				
				 orderVo.setSstation(rs.getString(1)); 
				 orderVo.setDepPlandTime(rs.getString(2));
				 orderVo.setStime(rs.getString(3));
				 orderVo.setRuntime(rs.getString(4));
				 orderVo.setDstation(rs.getString(5));
				 orderVo.setPrice(rs.getInt(6));
				 orderVo.setReservnum(rs.getString(7));
				 orderVo.setTrainnum(rs.getInt(8));
				 orderVo.setCharnum(rs.getString(9));
				 orderVo.setMid(rs.getString(10));
				 orderVo.setCancel(rs.getInt(11));
				 
				 orderList.add(orderVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
	
	
	
	
}
