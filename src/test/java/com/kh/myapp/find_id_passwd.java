package com.kh.myapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.member.dao.MemberDAOimpl;
import com.kh.myapp.member.dao.MemberDAOimplXML;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")

class find_id_passwd {
	public static final Logger logger = LoggerFactory.getLogger(find_id_passwd.class);
	@Autowired
	MemberDAOimpl memberDAO;
	@Test
	void test() {
		String id = memberDAO.findId("관리자", "1234");
		logger.info("찾은 아이디:"+id);
	}
	@Autowired
	MemberDAOimplXML memberDAOxml;
	@Test
	void othertest() {
		String id = memberDAOxml.findId("관리자","1234");
		logger.info("xml찾은 아이디:"+id);
	}
}
