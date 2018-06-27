package com.kh.myapp.bbs.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.RbbsDTO;


@Repository
public class RbbsDAOimplXML implements RbbsDAO {

	private Logger logger = LoggerFactory.getLogger(RbbsDAOimplXML.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void write(RbbsDTO rdto) throws Exception {
		sqlSession.insert("rbbsdao.write",rdto);
	}

}
