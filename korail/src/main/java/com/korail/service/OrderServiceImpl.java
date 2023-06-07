package com.korail.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.korail.dao.OrderDao;
import com.korail.vo.OrderVo;

@Service
public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDao = new OrderDao();
	
	@Override
	public ArrayList<OrderVo> getSelect() {
		return orderDao.select();
	}
	
	@Override
	public String getCancelResult(String reservnum) {
		int result = orderDao.update(reservnum);
		return String.valueOf(result);
	}
	
	@Override
	public OrderVo getSelected(String reservnum){
		return orderDao.selected(reservnum);
	}

	@Override
	public ArrayList<OrderVo> getOrderSelect(){
		return orderDao.orderselect();
	}

	public int getPayment(OrderVo orderVo) {
		
		return orderDao.insert(orderVo);
	}
}
