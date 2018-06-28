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
		sqlSession.insert("bbsdao.write", bbsdto);
	}

	@Override
	public List<BbsDTO> list() throws Exception {
		return sqlSession.selectList("bbsdao.list");
	}

	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		logger.info(recordCriteria);
		return sqlSession.selectList("bbsdao.listPageCri", recordCriteria);
	}

	@Override
	public List<BbsDTO> list(FindCriteria findCriteria) throws Exception {
		return sqlSession.selectList("bbsdao.listFindCri", findCriteria);
	}

	@Override
	public BbsDTO view(int bNum) throws Exception {
		return sqlSession.selectOne("bbsdao.view", bNum);
	}


	@Override
	public void delete(int bNum) {
		sqlSession.delete("bbsdao.delete",bNum);
	}

	@Override
	public BbsDTO preinfo(int bNum) {
		return sqlSession.selectOne("bbsdao.preInfo", bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) {
		sqlSession.insert("bbsdao.reply", bbsdto);
	}

	@Override
	public int totalrec() {
		return sqlSession.selectOne("bbsdao.totalRec");
	}


	@Override
	public int totalrec(String col, String keyword) {
		return sqlSession.selectOne("bbsdao.totalRec");
	}

	@Override
	public void modify(BbsDTO bbsdto) throws Exception {
		sqlSession.update("bbsdao.update",bbsdto);
	}

	@Override
	public int searchRec(FindCriteria findCriteria) throws Exception {
		return sqlSession.selectOne("bbsdao.searchRec", findCriteria);
	}

	@Override
	public void updateHit(int bnum) throws Exception {
		sqlSession.update("bbsdao.updatehit", bnum);
	}

	@Override
	public int getppage(int bnum) throws Exception {
		return sqlSession.selectOne("bbsdao.ppage", bnum);
	}

	@Override
	public int getnpage(int bnum) throws Exception {
		return sqlSession.selectOne("bbsdao.npage", bnum);
	}

}
