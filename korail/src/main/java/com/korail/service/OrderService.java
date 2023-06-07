package com.korail.service;

import java.util.ArrayList;

import com.korail.vo.OrderVo;

public interface OrderService {
	
	ArrayList<OrderVo> getSelect();

	OrderVo getSelected(String reservnum);
	
	public String getCancelResult(String reservnum);
	
	ArrayList<OrderVo> getOrderSelect();
	
	public int getPayment(OrderVo orderVo);
	
}
