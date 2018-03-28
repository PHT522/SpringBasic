package kh.com.a.dao;

import kh.com.a.model.MemberDto;

public interface KhMemberDao {

	boolean addmember(MemberDto mem) throws Exception;
	
	boolean idcheck(String id) throws Exception;
}
