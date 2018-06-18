package com.kh.myapp.bbs.controller;

import static java.lang.System.out;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.myapp.bbs.criteria.PageCriteria;
import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.service.BbsService;
import com.kh.myapp.bbs.vo.BbsDTO;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	@Autowired
	@Qualifier("bbsServiceXML")
	private BbsService bs;

	@RequestMapping(value = "/write", method = GET)
	public String writeGet(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("wite GET..");
		logger.info(bbsdto.toString());

		out.println();
		return "redirect:/bbs/list";
	}

	@RequestMapping(value = "/write", method = POST)
	public String writePost(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("wite Post..");
		logger.info(bbsdto.toString());

		bs.write(bbsdto);
		out.println();
		return "redirect:/bbs/list";
	}
	//답글등록
	@RequestMapping(value="/reply", method=POST)
	public String reply(BbsDTO bbsdto, Model model) throws Exception{
		logger.info("답글등록"+bbsdto);
		bs.reply(bbsdto);
		return "redirect:/bbs/list";
	}

	// 게시글 삭제
	@RequestMapping(value="/delete", method=GET)
	public String delete(@RequestParam("bnum") int bnum) throws Exception{
		logger.info("게시글 삭제:"+bnum);
		bs.delete(bnum);
		return "redirect:/bbs/list";
	}
	
	//게시글 수정
	@RequestMapping(value="/modify", method=GET)
	public String modify(@RequestParam("bnum") int bnum, BbsDTO bbsdto,
			Model model) throws Exception{
		logger.info("게시글 수정" + bnum);
		bs.modify(bbsdto);
		return "redirect:/bbs/view?bnum="+bnum;
	}
	
	//게시글보기
	@RequestMapping(value="/view", method=GET)
	public void view(@RequestParam("bnum")int bnum, Model model) throws Exception{
		
	}
	
	//게시글 검색
	@RequestMapping(value="/list", method=GET)
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int currPage =0;
		if(request.getParameter("currPage")==null||request.getParameter("currPage")=="") {
			currPage=1;
		}else {
			currPage = Integer.parseInt(request.getParameter("currPage"));
		}
		
		//검색조건 유무에 따른 분기
		String option = request.getParameter("option");
		String keyword = request.getParameter("keyword");
		
		List<BbsDTO> list = null;
		PageCriteria pc = null;
		RecordCriteria rc = null;
		
			if(keyword == null || keyword.trim().equals("")) {
				rc = new RecordCriteria(currPage);
				list = bs.list(rc);
			}
	}
	
}
