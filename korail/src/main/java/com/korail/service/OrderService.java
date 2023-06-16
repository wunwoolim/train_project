package com.korail.service;

import java.util.ArrayList;

import com.korail.vo.OrderVo;
import com.korail.vo.ReservationVo;
import com.korail.vo.SeatNumberVo;
import com.korail.vo.UpdateVo;

public interface OrderService {
	
	ArrayList<OrderVo> getSelect(OrderVo orderVo);

	OrderVo getSelected(String reservnum);
	
	public String getCancelResult(String reservnum);
	
	ArrayList<OrderVo> getOrderSelect(int startCount, int endCount);
	
	public ArrayList<OrderVo> getOrderSearch(int startCount, int endCount, String category, String cvalue);
	
	public int getPayment(OrderVo orderVo);
	
	public int getPaymentUpdate(OrderVo orderVo);
	
	public int getCardnum(String cardnum, String email);
	
	public ArrayList<SeatNumberVo> getSeatnum(ReservationVo rvo);
	
	public ArrayList<SeatNumberVo> getSeatnumUp(UpdateVo uvo);
}
