package com.kh.myapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.member.vo.MemberVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/test.xml"})
class blahblah {
	
	private static final Logger logger = LoggerFactory.getLogger(blahblah.class);
	@Autowired
	MemberVO logintest;
	
	@Test
	void test() {
		logger.info(logintest.toString());
	}

}
