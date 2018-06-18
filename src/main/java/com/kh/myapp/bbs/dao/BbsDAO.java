package com.kh.myapp.bbs.dao;

import java.util.List;

import com.kh.myapp.bbs.vo.BbsDTO;

public interface BbsDAO {

	void write(BbsDTO bbsdto);

	List<BbsDTO> list(int Startrec, int Lastrec);

	BbsDTO view(int bNum);

	BbsDTO modify(int num);

	int modify_ac(BbsDTO bdto);

	void delete(int bNum);

	BbsDTO preinfo(int bNum);

	BbsDTO reply(BbsDTO bbsdto);

	int totalrec();

	List<BbsDTO> list(int Startrec, int Lastrec, String keyword, String col);

	int totalrec(String col, String keyword);

}