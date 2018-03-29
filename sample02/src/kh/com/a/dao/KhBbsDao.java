package kh.com.a.dao;

import java.util.List;

import kh.com.a.model.BbsDto;

public interface KhBbsDao {

	List<BbsDto> getBbsList() throws Exception;
	boolean bbswriteAf(BbsDto bbs) throws Exception;
	//detail
	BbsDto getBbsDetail(int seq) throws Exception;
	//bbsupdate
	boolean bbsupdate(BbsDto bbs) throws Exception;
	//delete
	boolean deletebbs(int seq) throws Exception;
}
