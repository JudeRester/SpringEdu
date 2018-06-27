package com.kh.myapp.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.dao.RbbsDAO;
import com.kh.myapp.bbs.dto.RbbsDTO;

@Service
public class RbbsServiceImplXML implements RbbsService, RbbsDAO {
	@Autowired
	@Qualifier("rbbsDAOimplXML")
	private RbbsDAO rdao;	
	
	@Override
	public void write(RbbsDTO rdto) throws Exception {
		rdao.write(rdto);
	}

}
