package com.kh.myapp.member.dao;

import java.util.List;

import com.kh.myapp.member.vo.MemberVO;

public interface MemberDAO {
	
	public void insert(MemberVO memberVO);
	
	public MemberVO getMember(String id);
	
	public List<MemberVO> getMemberList();
	
	public void update(MemberVO memberVO);
	
	public void delete(String id);
}
