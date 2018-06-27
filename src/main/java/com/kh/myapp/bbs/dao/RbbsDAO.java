package com.kh.myapp.bbs.dao;

import com.kh.myapp.bbs.dto.RbbsDTO;

public interface RbbsDAO {
	//댓글등록
	void write(RbbsDTO rdto) throws Exception;
	
}
