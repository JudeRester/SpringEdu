package com.kh.myapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.myapp.bbs.criteria.FindCriteria;
import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.vo.BbsDTO;

class BbsTest {
	
	public static final Logger logger = LoggerFactory.getLogger(BbsTest.class);
	
	@Autowired
	BbsDAO bbsdao;

	@Test
	void modify_test() {
		
	}
	
	/*@Test
	@Disabled
	void replyView_test() {
		logger.info(bbsdao.replyView(1857).toString());
	}*/
	
	@Test
	void find_list_test() {
		List<BbsDTO> list = null;
		FindCriteria findCriteria = new FindCriteria(1,"TC","TEST");
		list=bbsdao.list(10,1);
		logger.info("검색목록리스트:"+bbsdao.totalrec());
	}
}
