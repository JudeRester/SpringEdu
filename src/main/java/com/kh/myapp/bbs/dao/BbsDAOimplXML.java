package com.kh.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.myapp.bbs.vo.BbsDTO;

public class BbsDAOimplXML implements BbsDAO {
	
	SqlSession sqlSession;

	@Override
	public void write(BbsDTO bbsdto) {
		sqlSession.insert("insert", bbsdto);
	}

	@Override
	public List<BbsDTO> list(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO view(int bNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO modify(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify_ac(BbsDTO bdto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int bNum) {
		sqlSession.delete("delete",bNum);
	}

	@Override
	public BbsDTO preinfo(int bNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO reply(BbsDTO bbsdto) {
		
		return null;
	}

	@Override
	public int totalrec() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BbsDTO> list(int a, int b, String keyword, String col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalrec(String col, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

}
