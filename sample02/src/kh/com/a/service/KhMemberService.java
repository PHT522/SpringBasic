package kh.com.a.service;

import kh.com.a.model.MemberDto;

public interface KhMemberService {

	boolean addmember(MemberDto mem) throws Exception;
	boolean idcheck(String id) throws Exception;
}
