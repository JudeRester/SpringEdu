package com.kh.myapp.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.criteria.FindCriteria;
import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;

@Service
public class BbsServiceImplXML implements BbsService {

	@Autowired
	@Qualifier("bbsDAOimplXML")
	private BbsDAO bbsDAO;
	
	@Override
	public void write(BbsDTO bbsdto) throws Exception {
		bbsDAO.write(bbsdto);
	}

	@Override
	public List<BbsDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modify(BbsDTO bbsdto) throws Exception {
		// TODO Auto-generated method stub

	}


	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		// TODO Auto-generated method stub

	}


	@Override
	public List<BbsDTO> list(FindCriteria findcriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO view(int bNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int bNum) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BbsDTO preinfo(int bNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalrec() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalrec(String col, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
