package com.kh.myapp.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.kh.myapp.bbs.criteria.FindCriteria;
import com.kh.myapp.bbs.criteria.PageCriteria;
import com.kh.myapp.bbs.vo.BbsDTO;

public class BbsServiceImplXML implements BbsService {

	@Autowired
	@Qualifier("BbsDAOImplXML")

	@Override
	public void write(BbsDTO bbsdto) throws Exception {

	}

	@Override
	public List<BbsDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BbsDTO> list(PageCriteria pageCriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO view(Integer bNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(BbsDTO bbsdto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer bNum) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int totalRec() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BbsDTO> list(FindCriteria findcriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchTotalRec(FindCriteria findCriteria) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
