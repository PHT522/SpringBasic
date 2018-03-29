package kh.com.a.service;

import java.util.List;

import kh.com.a.model.BbsDto;

public interface KhBbsService {

	public List<BbsDto> getBbsList() throws Exception;
	public boolean bbswriteAf(BbsDto bbs) throws Exception;
	BbsDto getBbsDetail(int seq) throws Exception;
	boolean bbsupdate(BbsDto bbs) throws Exception;
	boolean deletebbs(int seq) throws Exception;
}
