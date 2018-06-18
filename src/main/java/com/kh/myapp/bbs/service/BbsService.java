package com.kh.myapp.bbs.service;

import java.util.List;

import com.kh.myapp.bbs.criteria.FindCriteria;
import com.kh.myapp.bbs.criteria.PageCriteria;
import com.kh.myapp.bbs.vo.BbsDTO;

public interface BbsService {
	
	public void write(BbsDTO bbsdto) throws Exception;
	
	public List<BbsDTO> list() throws Exception;

	public List<BbsDTO> list(PageCriteria pageCriteria)  throws Exception;

	public BbsDTO view(Integer bNum) throws Exception;

	public void modify(BbsDTO bbsdto) throws Exception;

	public void delete(Integer bNum) throws Exception;

	public void reply(BbsDTO bbsdto) throws Exception;

	public int totalRec() throws Exception;

	public List<BbsDTO> list(FindCriteria findcriteria) throws Exception;

	public int searchTotalRec(FindCriteria findCriteria) throws Exception;

}
