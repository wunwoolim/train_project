package com.korail.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.korail.vo.StationVo;

public class StationDao extends DBConn {
	
	public StationVo select(String category, int rno, String sname, String type) {
		
		StationVo stationVo = new StationVo();
		String sql="";
		if(type.equals("c")) {
		sql = "SELECT RNO, STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK" + 
				" FROM (SELECT ROWNUM RNO, STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK" + 
				"        FROM( SELECT STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK" + 
				"                FROM KTX_STATION WHERE CATEGORY=? ORDER BY MLINK DESC))" + 
				" WHERE RNO = ? ";
		getPreparedStatement(sql);
				try {
					pstmt.setString(1, category);
					pstmt.setInt(2, rno);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		
		} else {
			sql = "SELECT RNO, STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK" + 
					" FROM (SELECT ROWNUM RNO, STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK" + 
					"        FROM( SELECT STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK" + 
					"                FROM KTX_STATION WHERE CATEGORY=? ORDER BY MLINK DESC))" + 
					" WHERE STATION = ? ";
			getPreparedStatement(sql);
			try {
				pstmt.setString(1, category);
				pstmt.setString(2, sname);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		
		try {			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stationVo.setRno(rs.getInt(1));
				stationVo.setStation(rs.getString(2));
				stationVo.setLocation(rs.getString(3));
				stationVo.setSphone(rs.getString(4));
				stationVo.setCategory(rs.getString(5));
				stationVo.setInfo(rs.getString(6));
				stationVo.setHistory(rs.getString(7));
				stationVo.setClink1(rs.getString(8));
				stationVo.setClink2(rs.getString(9));
				stationVo.setMlink(rs.getString(10));
				stationVo.setPlink(rs.getString(11));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stationVo;
	}
	
	
	  public ArrayList<String> getStationList(String category) { 
		  ArrayList<String> list = new ArrayList<String>(); 
		
		  String sql= "SELECT STATION FROM KTX_STATION WHERE CATEGORY=?";
		 getPreparedStatement(sql); 
		 try { 
			 pstmt.setString(1, category);
			 rs = pstmt.executeQuery(); 
			 while(rs.next()) { 
				 list.add(rs.getString(1));
			 }
			 
			 } catch (Exception e) {
				 e.printStackTrace(); 
			 } 
			 return list; 
	 }
	 
}
