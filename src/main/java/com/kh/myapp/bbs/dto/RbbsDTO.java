package com.kh.myapp.bbs.dto;

import java.sql.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@NoArgsConstructor
@Slf4j
public class RbbsDTO {

	private int rnum;
	private int bnum;
	private String rid;
	private String rname;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date rcdate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date rudate;
	private String rcontent;
	private int rgood;
	private int rbad;
	private int rgroup;
	private int rstep;
	private int rindent;
	
}
