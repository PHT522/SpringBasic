package kh.com.a.dao;

import kh.com.a.model.MemberDto;

public interface KhMemberDao {

	boolean addmember(MemberDto mem) throws Exception;
		
	public MemberDto login(MemberDto mem) throws Exception;
	
	//boolean logout(String id) throws Exception;
}
