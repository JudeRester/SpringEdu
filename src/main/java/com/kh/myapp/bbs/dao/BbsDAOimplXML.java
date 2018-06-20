package com.kh.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.criteria.FindCriteria;
import com.kh.myapp.bbs.criteria.RecordCriteria;
import com.kh.myapp.bbs.dto.BbsDTO;

@Repository
public class BbsDAOimplXML implements BbsDAO {
	
	private static final Logger logger = Logger.getLogger(BbsDAOimplXML.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(BbsDTO bbsdto) {
		sqlSession.insert("insert", bbsdto);
	}

	@Override
	public List<BbsDTO> list() throws Exception {
		return sqlSession.selectList("list");
	}

	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		logger.info(recordCriteria);
		return sqlSession.selectList("listPageCri", recordCriteria);
	}

	@Override
	public List<BbsDTO> list(FindCriteria findCriteria) throws Exception {
		return sqlSession.selectList("listFindCri", findCriteria);
	}

	@Override
	public BbsDTO view(int bNum) {
		return sqlSession.selectOne("view", bNum);
	}


	@Override
	public void delete(int bNum) {
		sqlSession.delete("delete",bNum);
	}

	@Override
	public BbsDTO preinfo(int bNum) {
		return sqlSession.selectOne("preInfo", bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) {
		
	}

	@Override
	public int totalrec() {
		return sqlSession.selectOne("totalRec");
	}


	@Override
	public int totalrec(String col, String keyword) {
		return 0;
	}

	@Override
	public void modify(BbsDTO bbsdto) throws Exception {
		sqlSession.update("modify",bbsdto);
	}

}
