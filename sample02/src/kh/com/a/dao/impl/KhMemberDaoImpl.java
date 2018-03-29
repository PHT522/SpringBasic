package kh.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhMemberDao;
import kh.com.a.model.MemberDto;

@Repository	/*저장소 db에서 데이터 뽑아온다 */
public class KhMemberDaoImpl implements KhMemberDao {

	
	@Autowired  //applicationContext.xml에서 생성된것을 자동으로 찾아준다 new로 생성해주는것과 동일
	SqlSession sqlSession;
	
	private String namespace = "KhMember.";	//.잊지말기

	@Override
	public boolean addmember(MemberDto mem) throws Exception {
		// simple or batch 확인
		System.out.println(sqlSession.getConfiguration().getDefaultExecutorType());
		
		int n = sqlSession.insert(namespace+"addmember", mem);
		return n>0?true:false;
	}

	
	@Override
	public MemberDto login(MemberDto mem) throws Exception {
		return sqlSession.selectOne(namespace+"login", mem);
	}

/*
	@Override
	public boolean logout(String id) throws Exception {		
		return sqlSession.selectOne(namespace+"logout", id);
	}*/
	
	
	
	
}
