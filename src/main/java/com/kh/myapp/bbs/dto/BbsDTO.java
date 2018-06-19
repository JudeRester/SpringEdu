package com.kh.myapp.bbs.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor // 디폴트 생성자
@Slf4j //로거
public class BbsDTO {
	
	private int bnum; //게시글 번호
	private String btitle; //게시글 제목
	private String bid; //작성자 아이디
	private String bname; //작성자 이름
	private String bcontent; //내용
	private int bindent; //답글 들여쓰기
	private Date bcdate; //작성일
	private Date budate; //수정일
	private int bhit; //조회수
	private int bgroup; //답글 그룹
	private int bstep; //답글 단계
	private int ppage;
	private int npage;
}
