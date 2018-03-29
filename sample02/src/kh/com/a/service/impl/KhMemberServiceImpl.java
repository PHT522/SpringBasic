package kh.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.a.dao.KhMemberDao;
import kh.com.a.model.MemberDto;
import kh.com.a.service.KhMemberService;

@Service
public class KhMemberServiceImpl implements KhMemberService {

	@Autowired //찾아서 자동으로 daoimpe을 집어넣어준다
	private KhMemberDao khMemberDao;

	@Override
	public boolean addmember(MemberDto mem) throws Exception {
		return khMemberDao.addmember(mem);
	}

	@Override
	public MemberDto login(MemberDto mem) throws Exception {
		return khMemberDao.login(mem);
	}

	/*@Override
	public boolean logout(String id) throws Exception {
		return khMemberDao.logout(id);
	}
*/
	
	
	
}
