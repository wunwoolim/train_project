package com.korail.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korail.dao.PageDao;

@Service("pageService")
public class PageServiceImpl {
	
	@Autowired
	private PageDao pageDao;
	

		
	public Map<String, Integer> getPageResult(String page, String serviceName, String category, String cvalue) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 0;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;	//DB���� ������ ��ü ���
		
		//dbCount = pageDao.totalRowCount(serviceName, category, cvalue);
		
		if(serviceName.equals("notice")) {	
			dbCount = pageDao.noticeTotalRowCount(category, cvalue);
			pageSize = 3;
		} else if(serviceName.equals("member")) {	
			dbCount = pageDao.totalRowCount(serviceName, category, cvalue);
			pageSize = 5;
		} else if(serviceName.equals("adminReserv")) {
			dbCount = pageDao.totalRowCount(serviceName, category, cvalue);
			pageSize = 5;
		}		
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		} else{
			pageCount = dbCount/pageSize+1;
		}
		
		//��û ������ ���
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		} else{
			startCount = 1;
			endCount = pageSize;
		}
		System.out.println("dbcount-----"+dbCount);
		//param ��ü��  ������ put
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		return param;
	}

	
	public Map<String, Integer> getPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 0;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;	//DB���� ������ ��ü ���
		
		dbCount = pageDao.totalRowCount(serviceName);
		
		
		if(serviceName.equals("notice")) {			
			pageSize = 3;
		} else if(serviceName.equals("member")) {			
			pageSize = 5;
		} else if(serviceName.equals("adminReserv")) {
			pageSize = 5;
		}
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		} else{
			pageCount = dbCount/pageSize+1;
		}

		//��û ������ ���
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		} else{
			startCount = 1;
			endCount = pageSize;
		}
		
		//param ��ü��  ������ put
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		return param;
	}
}