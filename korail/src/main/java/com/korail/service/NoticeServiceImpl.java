package com.korail.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.korail.vo.NoticeVo;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Override
	public int getInsert(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NoticeVo> getSelect(int startCount, int endCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeVo getSelect(String bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUpdate(NoticeVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDelete(String bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getUpdateHits(String bid) {
		// TODO Auto-generated method stub
		
	}

}
