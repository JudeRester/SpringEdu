package com.kh.myapp.bbs.dao;

import java.util.List;

import com.kh.myapp.bbs.criteria.FindCriteria;
import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.dto.BbsDTO;

public interface BbsDAO {

	void write(BbsDTO bbsdto) throws Exception;

	//List<BbsDTO> list(int Startrec, int Lastrec) throws Exception;
	
	List<BbsDTO> list() throws Exception;
	
	List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception;

	BbsDTO view(int bNum) throws Exception;

/*	BbsDTO modify(int num) throws Exception;

	int modify_ac(BbsDTO bdto) throws Exception;*/

	void modify(BbsDTO bbsdto) throws Exception;
	
	void delete(int bNum) throws Exception;

	BbsDTO preinfo(int bNum) throws Exception;

	void reply(BbsDTO bbsdto) throws Exception;

	int totalrec() throws Exception;

	List<BbsDTO> list(FindCriteria findCriteria) throws Exception;	
	
	//List<BbsDTO> list(int Startrec, int Lastrec, String keyword, String col) throws Exception;

	int totalrec(String col, String keyword) throws Exception;
	
	int searchRec(FindCriteria findCriteria) throws Exception;
}