package com.korail.service;

import java.util.ArrayList;

import com.korail.vo.NoticeVo;

public interface NoticeService {
	int getInsert(NoticeVo noticeVo);
	ArrayList<NoticeVo> getSelect(int startCount, int endCount);
	NoticeVo getSelect(String bid);
	int getUpdate(NoticeVo boardVo);
	int getDelete(String bid);
	void getUpdateHits(String bid);

}
