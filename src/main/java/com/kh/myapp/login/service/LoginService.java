package com.kh.myapp.login.service;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

public interface LoginService {
	//회원정보 가져오기
	public MemberVO getMember(LoginVO loginVO);
}
