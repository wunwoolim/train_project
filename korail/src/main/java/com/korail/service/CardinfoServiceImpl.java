package com.korail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.CardinfoDao;
import com.korail.vo.CardinfoVo;

@Service
public class CardinfoServiceImpl {
   @Autowired
   private CardinfoDao cardinfoDao;
   
   
   public int getPayment(CardinfoVo cardVo) {
      return cardinfoDao.insert(cardVo);
   }
   
	/*
	 * public int getPaymentUpdate(CardinfoVo cardVo) { return
	 * cardinfoDao.insertUpdate(cardVo); }
	 */
}