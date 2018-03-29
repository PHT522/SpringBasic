package kh.com.a.dao.impl;

import java.util.List;
	
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhBbsDao;
import kh.com.a.model.BbsDto;

@Repository	
public class KhBbsDaoImpl implements KhBbsDao {
	
	@Autowired
	SqlSession sqlSession;
	
	private String ns = "KhBbs.";
	
	@Override
	public List<BbsDto> getBbsList() throws Exception {
		List<BbsDto> list = sqlSession.selectList(ns+ "getBbsList");		
		return list;
	}

	@Override
	public boolean bbswriteAf(BbsDto bbs) throws Exception {		
		int n = 0;		
		n = sqlSession.insert(ns+"bbswriteAf", bbs);		
		return n>0?true:false;
	}

	@Override
	public BbsDto getBbsDetail(int seq) throws Exception {
		BbsDto bbs = sqlSession.selectOne(ns+"bbsdetail", seq);
		return bbs;
	}

	@Override
	public boolean bbsupdate(BbsDto bbs) throws Exception {
		int b = sqlSession.update(ns+"bbsupdate", bbs);
		return b>0?true:false;
	}

	@Override
	public boolean deletebbs(int seq) throws Exception {
		int b = sqlSession.update(ns+"bbsdelete", seq);
		return b>0;
	}
	
	
	

}












