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
		return bbsDAO.list();
	}


	@Override
	public void modify(BbsDTO bbsdto) throws Exception {
		bbsDAO.modify(bbsdto);
	}


	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		bbsDAO.reply(bbsdto);
	}


	@Override
	public List<BbsDTO> list(FindCriteria findcriteria) throws Exception {
		return bbsDAO.list(findcriteria);
	}


	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		return bbsDAO.list(recordCriteria);
	}

	@Override
	public BbsDTO view(int bNum) throws Exception {
		return bbsDAO.view(bNum);
	}

	@Override
	public void delete(int bNum) throws Exception {
		bbsDAO.delete(bNum);
	}

	@Override
	public BbsDTO preinfo(int bNum) throws Exception {
		return bbsDAO.preinfo(bNum);
	}

	@Override
	public int totalrec() throws Exception {
		return bbsDAO.totalrec();
	}

	@Override
	public int totalrec(String col, String keyword) throws Exception {
		return bbsDAO.totalrec(col, keyword);
	}

	@Override
	public int searchRec(FindCriteria findCriteria) throws Exception {
		return bbsDAO.searchRec(findCriteria);
	}

}
