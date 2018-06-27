package com.kh.myapp.bbs.service;

import java.util.List;

import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.dto.RbbsDTO;

public interface RbbsService {
	//댓글등록
	void write(RbbsDTO rdto) throws Exception;
	//요청페이지 댓글
	List<RbbsDTO> list(int bnum, RecordCriteria rc) throws Exception;
	//댓글 수정
	void modify(RbbsDTO rdto) throws Exception;
	//댓글 삭제
	void delete(int rnum) throws Exception;
	//대댓글
	void reply(RbbsDTO rdto) throws Exception;
	//엄지엄지처억~
	void vote(int rnum, String vote) throws Exception;
	//댓글 총 레코드
	int replyTotalRec(int bnum) throws Exception;
	//대댓 대상 정보
	RbbsDTO preinfo(int rnum) throws Exception;
}
