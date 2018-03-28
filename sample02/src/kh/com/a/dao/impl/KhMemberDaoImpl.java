package kh.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhMemberDao;

@Repository	/*저장소 db에서 데이터 뽑아온다 */
public class KhMemberDaoImpl implements KhMemberDao {

	
	@Autowired  //applicationContext.xml에서 생성된것을 자동으로 찾아준다 new로 생성해주는것과 동일
	SqlSession sqlSession;
	
}
