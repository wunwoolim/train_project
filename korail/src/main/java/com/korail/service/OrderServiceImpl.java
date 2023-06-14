package com.korail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.OrderDao;
import com.korail.vo.OrderVo;
import com.korail.vo.ReservationVo;
import com.korail.vo.SeatNumberVo;
import com.korail.vo.UpdateVo;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public ArrayList<SeatNumberVo> getSeatnum(ReservationVo rvo){
		
		List<SeatNumberVo> list = orderDao.seatnum(rvo);	
		
		return (ArrayList<SeatNumberVo>)list;
	}
	
	@Override
	public ArrayList<SeatNumberVo> getSeatnumUp(UpdateVo uvo){
		
		List<SeatNumberVo> list = orderDao.seatnumUp(uvo);	
		
		return (ArrayList<SeatNumberVo>)list;
	}
	
	@Override
	public ArrayList<OrderVo> getSelect(OrderVo orderVo) {
		return orderDao.select(orderVo);
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
	public ArrayList<OrderVo> getOrderSelect(int startCount, int endCount){
		ArrayList<OrderVo> rlist = new ArrayList<OrderVo>();
		List<Object> list = orderDao.orderselect(startCount, endCount);
		for(Object obj : list) {
			OrderVo orderVo = (OrderVo)obj;
			rlist.add(orderVo);
		}
		return rlist;
	}
	
	
	@Override
	public int getPayment(OrderVo orderVo) {
		
		return orderDao.insert(orderVo);
	}
	
	@Override
	public int getPaymentUpdate(OrderVo orderVo) {
		return orderDao.updatePayment(orderVo);
	}
	
	@Override
	public int getCardnum(String cardnum) {
		return orderDao.selectCardnum(cardnum);
	}
}
