package com.korail.dao;

import java.util.ArrayList;

import com.korail.vo.StationVo;

public class StationDao extends DBConn {
	
	public StationVo select(String k) {
		StationVo stationVo = new StationVo();
		String sql = "SELECT STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK "
				+ "FROM(SELECT STATION, LOCATION, SPHONE, CATEGORY, INFO, HISTORY, CLINK1, CLINK2, MLINK, PLINK "
				+ "FROM KTX_STATION WHERE CATEGORY=? ORDER BY MLINK DESC) WHERE ROWNUM = 1";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, k);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stationVo.setStation(rs.getString(1));
				stationVo.setLocation(rs.getString(2));
				stationVo.setSphone(rs.getString(3));
				stationVo.setCategory(rs.getString(4));
				stationVo.setInfo(rs.getString(5));
				stationVo.setHistory(rs.getString(6));
				stationVo.setClink1(rs.getString(7));
				stationVo.setClink2(rs.getString(8));
				stationVo.setMlink(rs.getString(9));
				stationVo.setPlink(rs.getString(10));
				
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
