package com.kh.myapp.login.dao;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

public interface LoginDAO {
	
	public MemberVO getMember(LoginVO loginVO);
	
}
