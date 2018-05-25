package com.kh.member.dao;

import java.util.ArrayList;

import com.kh.member.vo.MemberVO;

public interface MemberDAO {
	
	public void insert(MemberVO memberVO);
	
	public MemberVO getMember(String id);
	
	public ArrayList<MemberVO> getMemberList();
	
	public void delete(String id);

	void update(MemberVO memVO);
}
