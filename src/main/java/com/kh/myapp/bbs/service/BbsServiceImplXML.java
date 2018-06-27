package com.kh.myapp.bbs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.criteria.FindCriteria;
import com.kh.myapp.bbs.criteria.PageCriteria;
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
		BbsDTO bdto;
		bbsDAO.updateHit(bNum);
		bdto = bbsDAO.view(bNum);
		
		try {
			bdto.setNpage(bbsDAO.getnpage(bNum));
		}catch(Exception e) {
			bdto.setNpage(bNum);
		}
		try{
			bdto.setPpage(bbsDAO.getppage(bNum));
		}catch(Exception e) {
			bdto.setPpage(bNum);
		}
		return bdto;
		
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

	@Override
	public void list(HttpServletRequest request) throws Exception {
		
		
		int currPage =0;
		
		
		if(request.getParameter("currPage")==null||request.getParameter("currPage")=="") {
			currPage=1;
		}else {
			currPage = Integer.parseInt(request.getParameter("currPage"));
		}
		
		System.out.println(currPage);
		
		//검색조건 유무에 따른 분기
		String option = request.getParameter("option");
		String keyword = request.getParameter("keyword");
		
		List<BbsDTO> list = null;
		PageCriteria pc = null;
		RecordCriteria rc = null;
		
			if(keyword == null || keyword.trim().equals("")) {
				rc = new RecordCriteria(currPage);
				list = this.list(rc);
				int totalRec = this.totalrec();
				pc = new PageCriteria(rc, totalRec);
			}else {
				rc= new FindCriteria(currPage, option, keyword);
				list = this.list((FindCriteria)rc);
				int totalRec=this.searchRec((FindCriteria)rc);
				pc = new PageCriteria(rc,totalRec);
				
				request.setAttribute("findCriteria", (FindCriteria)rc);
				
			}
			request.setAttribute("list", list);
			request.setAttribute("pc", pc);
	}

}
