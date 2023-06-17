package com.korail.service;

import java.util.ArrayList;

import com.korail.vo.NoticeVo;

public interface NoticeService {
	int getInsert(NoticeVo noticeVo);
	ArrayList<NoticeVo> getSelect(int startCount, int endCount);
	NoticeVo getSelect(String nid);
	int getUpdate(NoticeVo noticeVo);
	int getDelete(String nid);
	void getUpdateHits(String nid);
	ArrayList<NoticeVo> getList(int startCount, int endCount, String category, String cvalue);
	public ArrayList<NoticeVo> getNid(String nid);
		
}
