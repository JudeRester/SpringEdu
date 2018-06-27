package com.kh.myapp.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.criteria.RecordCriteria;
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

	@Override
	public List<RbbsDTO> list(int bnum, RecordCriteria rc) throws Exception {
		return rdao.list(bnum, rc);
	}

	@Override
	public void modify(RbbsDTO rdto) throws Exception {
		rdao.modify(rdto);
	}

	@Override
	public void delete(int rnum) throws Exception {
		rdao.delete(rnum);
	}

	@Override
	public void reply(RbbsDTO rdto) throws Exception {
		rdao.reply(rdto);
	}

	@Override
	public void vote(int rnum, String vote) throws Exception {
		rdao.vote(rnum, vote);
	}

	@Override
	public int replyTotalRec(int bnum) throws Exception {
		return rdao.replyTotalRec(bnum);
	}

	@Override
	public RbbsDTO preinfo(int rnum) throws Exception {
		return rdao.preinfo(rnum);
	}

}
