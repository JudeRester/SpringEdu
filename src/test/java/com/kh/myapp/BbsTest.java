package com.kh.myapp;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;




@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class BbsTest {
	
	public static final Logger logger = LoggerFactory.getLogger(BbsTest.class);
	
	@Autowired
	@Qualifier("bbsDAOimplXML")
	BbsDAO bbsdao;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	void modify_test() {
		
	}
	
	/*@Test
	@Disabled
	void replyView_test() {
		logger.info(bbsdao.replyView(1857).toString());
	}*/
	
/*	@Test
	void find_list_test() {
		List<BbsDTO> list = null;
		FindCriteria findCriteria = new FindCriteria(1,"TC","TEST");
		list=bbsdao.list(10,1);
		logger.info("검색목록리스트:"+bbsdao.totalrec());
	}*/
	
	@Test
	void list_test() throws Exception {
		List<BbsDTO> list;

		RecordCriteria rc = new RecordCriteria(1);
		list = bbsdao.list(rc);
		logger.info("시작레코드:"+rc.getStartRecord()+",종료레코드:"+rc.getEndRecord());
		logger.info("목록수:" + list.size());
	}
	@Test
	@Disabled
	void listAll_test() throws Exception {
		List<BbsDTO> list;

		list = bbsdao.list();

		logger.info("목록수:" + list.size());

	}
	
}
