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
	
	//�������� �󼼺���
	public NoticeVo select(String nid){
		return sqlSession.selectOne("mapper.notice.content", nid);
	}
	
	//�������� ��ü ����Ʈ
	public ArrayList<NoticeVo> select(){
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");		
		return (ArrayList<NoticeVo>)list;		
	}
	
	public ArrayList<NoticeVo> selectNid() {
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list3");
		return (ArrayList<NoticeVo>)list;
	}
	
	//�������� ��ü ����Ʈ(����¡ ó��)
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
	
	//�������� ���
	public int insert(Object noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);		
	}
	
	//�������� ����
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);		
	}
	
	//�������� ����
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
	}
	
	//�������� ��ȸ�� ������Ʈ
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.updateHits", nid);
	}

}