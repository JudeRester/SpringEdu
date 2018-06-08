package com.kh.myapp.bbs.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor // 디폴트 생성자
@Slf4j //로거
public class BbsDTO {
	
	private int bNum; //게시글 번호
	private String bTitle; //게시글 제목
	private String bId; //작성자 아이디
	private String bName; //작성자 이름
	private String bContent; //내용
	private int bIndent; //답글 들여쓰기
	private Date bCDate; //작성일
	private Date bUDate; //수정일
	private int bHit; //조회수
	private int bGroup; //답글 그룹
	private int bStep; //답글 단계
	private int pPage;
	private int nPage;
}
