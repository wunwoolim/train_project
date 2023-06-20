package com.korail.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korail.vo.NoticeVo;

@Repository
public class NoticeDao implements MyktxDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//공지사항 상세보기
	public NoticeVo select(String nid){
		return sqlSession.selectOne("mapper.notice.content", nid);
	}
	
	//공지사항 전체 리스트
	public ArrayList<NoticeVo> select(){
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");		
		return (ArrayList<NoticeVo>)list;		
	}
	
	public ArrayList<NoticeVo> selectNid() {
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list3");
		return (ArrayList<NoticeVo>)list;
	}
	
	//공지사항 전체 리스트(페이징 처리)
	@Override
	public List<Object> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.notice.list", param);		
	}
	
	
	public ArrayList<NoticeVo> select(int startCount, int endCount, String category, String cvalue) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));
		param.put("category", category);
		param.put("cvalue", cvalue);
		List<NoticeVo> nlist = sqlSession.selectList("mapper.notice.notice_list", param);
		return (ArrayList<NoticeVo>)nlist;
	}
	
	//공지사항 등록
	public int insert(Object noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);		
	}
	
	//공지사항 수정
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);		
	}
	
	//공지사항 삭제
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
	}
	
	//공지사항 조회수 업데이트
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.updateHits", nid);
	}

}