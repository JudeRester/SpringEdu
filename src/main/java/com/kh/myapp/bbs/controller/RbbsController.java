package com.kh.myapp.bbs.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myapp.bbs.criteria.PageCriteria;
import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.bbs.service.RbbsService;

@RestController
@RequestMapping("/rbbs")
public class RbbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(RbbsController.class);
	
	@Autowired
	@Qualifier("rbbsServiceImplXML")
	RbbsService rbbsService;
	
	//댓글 등록
		@RequestMapping(value="/write", method=POST)
		public ResponseEntity<String> write(@RequestBody RbbsDTO rdto){
			ResponseEntity<String> responseEntity = null;
			logger.info(rdto.toString());
			try {
				rbbsService.write(rdto);
				responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
			}
			return responseEntity;
		}
	//요청 페이지 댓글
	@RequestMapping(value="/map/{bnum}/{recurrPage}", method=GET)
	public ResponseEntity<Map<String,Object>>map2(@PathVariable int bnum,
													@PathVariable int recurrPage){
		ResponseEntity<Map<String,Object>> responseEntity = null;
		Map<String,Object> map = new HashMap<>();
		RecordCriteria rc = new RecordCriteria(recurrPage,10);
		try {
			//페이지 처리
			PageCriteria pc = new PageCriteria(rc, rbbsService.replyTotalRec(bnum),10);
			//===
			
			map.put("item", rbbsService.list(bnum, rc));
			map.put("pc", pc);
			responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	//댓글 수정
	@RequestMapping(value="/modify", method=PUT)
	public ResponseEntity<String> modify(@RequestBody RbbsDTO rdto){
		ResponseEntity<String> responseEntity = null;
		try {
			rbbsService.modify(rdto);
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	//댓글 삭제
	@RequestMapping(value="/delete/{rnum}",method=DELETE)
	public ResponseEntity<String> delete(@PathVariable int rnum){
		ResponseEntity<String> responseEntity = null;
		try {
			rbbsService.delete(rnum);
			responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	//좋아요
	@RequestMapping(value="/good/{rnum}",method=PUT)
	public ResponseEntity<String> good(@PathVariable int rnum){
		ResponseEntity<String> responseEntity = null;
		try {
			rbbsService.vote(rnum, "good");
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	//나빠요
	@RequestMapping(value="/bad/{rnum}",method=PUT)
	public ResponseEntity<String> bad(@PathVariable int rnum){
		ResponseEntity<String> responseEntity = null;
		try {
			rbbsService.vote(rnum, "bad");
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	//대댓
	@RequestMapping(value="/reply", method=POST)
	public ResponseEntity<String> reply(@RequestBody RbbsDTO rdto){
		ResponseEntity<String> responseEntity = null;
		logger.info(rdto.toString());
		try {
			rbbsService.reply(rdto);
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
