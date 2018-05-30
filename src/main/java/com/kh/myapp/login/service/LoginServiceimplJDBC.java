package com.kh.myapp.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kh.myapp.login.dao.LoginDAO;
import com.kh.myapp.member.vo.MemberVO;

@Service
public class LoginServiceimplJDBC implements LoginService {
	
	private JdbcTemplate jTemplate;

	@Autowired
	LoginDAO loginDAO;
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return loginDAO.getMember(memberVO);
	}

}
