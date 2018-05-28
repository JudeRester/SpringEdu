package com.kh.myapp.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.vo.MemberVO;

@Service
public class MemberServiceimpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;	
	
	@Override
	public void memberInsert(MemberVO memberVO) {
		memberDAO.insert(memberVO);
	}

	@Override
	public MemberVO getByMemberId(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		return memberDAO.getMemberList();
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
		memberDAO.update(memberVO);
	}

	@Override
	public void memberDelete(String id) {
		memberDAO.delete(id);
	}

	@Override
	public ArrayList<MemberVO> getMemberAll() {
		return memberDAO.getMemberList();
	}

}