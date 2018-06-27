package com.kh.myapp.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.dto.RbbsDTO;


@Repository
public class RbbsDAOimplXML implements RbbsDAO {

	private Logger logger = LoggerFactory.getLogger(RbbsDAOimplXML.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void write(RbbsDTO rdto) throws Exception {
		sqlSession.insert("rbbsdao.write",rdto);
	}

	@Override
	public List<RbbsDTO> list(int bnum, RecordCriteria rc) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("bnum", bnum);
		map.put("rc", rc);
		
		return sqlSession.selectList("rbbsdao.list",map);
	}

	@Override
	public void modify(RbbsDTO rdto) throws Exception {
		sqlSession.update("rbbsdao.update", rdto);
	}

	@Override
	public void delete(int rnum) throws Exception {
		sqlSession.delete("rbbsdao.delete", rnum);
	}

	@Override
	public void reply(RbbsDTO rdto) throws Exception {
		RbbsDTO rbbsdto = preinfo(Integer.valueOf(rdto.getRnum()));
		
		rdto.setBnum(rbbsdto.getBnum());
		rdto.setRgroup(rbbsdto.getRnum());
		rdto.setRindent(rbbsdto.getRindent()+1);
		
		sqlSession.insert("rbbsdao.reply",rdto);
	}

	@Override
	public void vote(int rnum, String vote) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("rnum", rnum);
		map.put("vote", vote);
		sqlSession.update("rbbsdao.vote", map);
	}

	@Override
	public int replyTotalRec(int bnum) throws Exception {
		return sqlSession.selectOne("rbbsdao.replyTotalRec", bnum);
	}

	@Override
	public RbbsDTO preinfo(int rnum) throws Exception {
		return sqlSession.selectOne("rbbsdao.preinfo", rnum);
	}

}
