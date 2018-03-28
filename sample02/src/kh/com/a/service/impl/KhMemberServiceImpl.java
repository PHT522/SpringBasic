package kh.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.a.dao.KhMemberDao;
import kh.com.a.service.KhMemberService;

@Service
public class KhMemberServiceImpl implements KhMemberService {

	@Autowired //찾아서 자동으로 daoimpe을 집어넣어준다
	private KhMemberDao khMemberDao;
	
}
