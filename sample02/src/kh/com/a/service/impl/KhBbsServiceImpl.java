package kh.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.a.dao.KhBbsDao;
import kh.com.a.model.BbsDto;
import kh.com.a.service.KhBbsService;

@Service
public class KhBbsServiceImpl implements KhBbsService {
	
	@Autowired
	KhBbsDao khBbsDao;
	
	
	@Override
	@Transactional(readOnly=true)	//건들지마라 공동작업시 편함
	public List<BbsDto> getBbsList() throws Exception {
		return khBbsDao.getBbsList();
	}


	@Override
	public boolean bbswriteAf(BbsDto bbs) throws Exception {
		return khBbsDao.bbswriteAf(bbs);
	}


	@Override
	public BbsDto getBbsDetail(int seq) throws Exception {
		return khBbsDao.getBbsDetail(seq);
	}


	@Override
	public boolean bbsupdate(BbsDto bbs) throws Exception {
		return khBbsDao.bbsupdate(bbs);
	}


	@Override
	public boolean deletebbs(int seq) throws Exception {
		return khBbsDao.deletebbs(seq);
	}

	
	
	
}
