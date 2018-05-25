package com.kh.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.member.vo.MemberVO;

public class MemberDAOimpl implements MemberDAO{

	private JdbcTemplate jtemplate;
	public void setDataSource(DataSource dataSource) {
		this.jtemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void insert(MemberVO memberVO) {
		StringBuffer str = new StringBuffer();
		str.append("insert into member(id, passwd, name, birth, phone, gender)")
		.append(" values(?,?,?,?,?,?)");
		try {
		this.jtemplate.update(str.toString(),
				memberVO.getId(),
				memberVO.getPasswd(),
				memberVO.getName(),
				memberVO.getBirth(),
				memberVO.getPasswd(),
				memberVO.getGender()
				);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MemberVO getMember(String id) {
		
		MemberVO memVO = new MemberVO();
		StringBuffer str = new StringBuffer();
		str.append("select * from member where id = ?");
		memVO = (MemberVO)this.jtemplate.query(str.toString(),
				new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		return memVO;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		ArrayList<MemberVO> alist = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		str.append("select * from member");
		alist = (ArrayList<MemberVO>)this.jtemplate.query(str.toString(),
				new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		
		return alist;
	}

	@Override
	public void update(MemberVO memVO) {
		StringBuffer str = new StringBuffer();
		str.append("update member set")
		   .append(" passwd = ?, name = ?, birth=?,phone=?,gender =?")
		   .append(" where id =?");
		this.jtemplate.update(str.toString(),memVO.getPasswd(),memVO.getName()
				,memVO.getBirth(),memVO.getPhone(),memVO.getGender(),memVO.getId());
	}

	@Override
	public void delete(String id) {
		this.jtemplate.update("delete from member where = ?", id);
	}

}
