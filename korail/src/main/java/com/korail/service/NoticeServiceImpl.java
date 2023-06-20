package com.korail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.korail.dao.NoticeDao;
import com.korail.vo.NoticeVo;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired 
	private NoticeDao noticeDao;
	
	@Override
	public int getInsert(NoticeVo noticeVo) {
		return noticeDao.insert(noticeVo);
	}
	
	@Override
	public ArrayList<NoticeVo> getSelect(int startCount, int endCount) {
		ArrayList<NoticeVo> rlist = new ArrayList<NoticeVo>();
		List<Object> list = noticeDao.select(startCount, endCount);
		for(Object obj : list) {
			NoticeVo noticeVo = (NoticeVo)obj;
			rlist.add(noticeVo);
		}
		return rlist;
	}
	 public ArrayList<NoticeVo> getNid(String nid) { 
		 return noticeDao.selectNid(); 
		}
	
	@Override
	public NoticeVo getSelect(String nid) {
		return noticeDao.select(nid);
	}
	
	@Override
	public int getUpdate(NoticeVo noticeVo) {
		return noticeDao.update(noticeVo);
	}
	
	@Override
	public int getDelete(String nid) {
		return noticeDao.delete(nid);
	}

	@Override
	public void getUpdateHits(String nid) {
		noticeDao.updateHits(nid);
	}

	@Override
	public ArrayList<NoticeVo> getList(int startCount, int endCount, String category, String cvalue) {
		/*
		 * ArrayList<NoticeVo> rlist = new ArrayList<NoticeVo>(); //List<Object> list =
		 * noticeDao.select(startCount, endCount, category, cvalue); for(Object obj :
		 * list) { NoticeVo noticeVo = (NoticeVo) obj; rlist.add(noticeVo); }
		 */
		return noticeDao.select(startCount, endCount, category, cvalue);
	}

}