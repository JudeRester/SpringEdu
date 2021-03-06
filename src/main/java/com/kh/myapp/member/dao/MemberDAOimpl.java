package com.kh.myapp.member.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

@Repository
public class MemberDAOimpl implements MemberDAO{

	private JdbcTemplate jtemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jtemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void insert(MemberVO memberVO) {
		StringBuffer str = new StringBuffer();
		str.append("insert into member(id, passwd, name, birth, phone, gender)")
		.append(" values(?,?,?,?,?,?)");
		
		try {
			System.out.println(memberVO.getId()+"/"+
					memberVO.getPasswd()+"/"+
					memberVO.getName()+"/"+
					memberVO.getBirth()+"/"+
					memberVO.getPhone()+"/"+
					memberVO.getGender());
			this.jtemplate.update(str.toString(),
				memberVO.getId(),
				memberVO.getPasswd(),
				memberVO.getName(),
				memberVO.getBirth(),
				memberVO.getPhone(),
				memberVO.getGender());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MemberVO getMember(String id) {
		
		MemberVO memVO = new MemberVO();
		StringBuffer str = new StringBuffer();
		str.append("select * from member where id = ?");
		memVO = (MemberVO)this.jtemplate.queryForObject(str.toString(), new Object[] {id},
				new BeanPropertyRowMapper<>(MemberVO.class));
		
		return memVO;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		ArrayList<MemberVO> alist = new ArrayList<MemberVO>();
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
		this.jtemplate.update("delete from member where id = ?", id);
	}
	@Override
	public String findId(String name, String phone) {
		String id = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id from member where name = ? and phone = ?");
		id = this.jtemplate.queryForObject(sql.toString(), new Object[] {name,  phone}, String.class);
		return id;
	}
	@Override
	public String findPw(String id, String name, String phone) {
		String pw = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select passwd from member where id = ? and name = ? and phone = ?");
		pw = this.jtemplate.queryForObject(sql.toString(), new Object[] {id,name,phone}, String.class);
		return pw;
	}

}
