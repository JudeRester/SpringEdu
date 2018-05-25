package com.kh.myapp;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.member.dao.MemberDAOimpl;
import com.kh.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class JdbcTemplateTest {
	private static final Logger logger = LoggerFactory.getLogger(DBConnTest.class);
	@Autowired
	DataSource ds;
	private MemberDAOimpl memberDAO = new MemberDAOimpl();
	
	@Test
	public void test() {
		memberDAO.setDataSource(ds);
		logger.info(memberDAO.toString());
		MemberVO memVO= new MemberVO();
		memVO.setId("admin2@kh.com");
		memVO.setPasswd("1234");
		memVO.setName("관리자");
		memVO.setBirth("20000101");
		memVO.setPhone("01012345678");
		memVO.setGender("w");
		memberDAO.insert(memVO);
	}
	@Autowired
	DefaultListableBeanFactory df;
	@Test
	public void beans() {
		for(String name : df.getBeanDefinitionNames()) {
			logger.info(name+"\t"+df.getBean(name).getClass().getName());
		}
	}
}
