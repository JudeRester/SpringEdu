package com.kh.myapp.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOimplJDBC implements LoginDAO {

	/*
	 * JdbcTemplater 객체가 root-context.xml에 빈으로 등럭되어있어 주석처리
	 * @Autowired public void setDAtaSource(DataSource dataSource){
	 * this.jdbcTemplate = new JdbcTemplate(dataSource);
	 * }
	 */
	@Autowired
	private JdbcTemplate jTemplate;
	
	@Override
	public MemberVO getMember(LoginVO loginVO) {
		MemberVO memVO;
		StringBuffer str = new StringBuffer();
		str.append("select id, passwd, name, birth, phone, gender, cdate, udate")
		.append(" from member")
		.append(" where id = ? and passwd = ?");
		memVO = this.jTemplate.queryForObject(
                 str.toString(), new Object[] {loginVO.getId(), loginVO.getPasswd()},
                 new BeanPropertyRowMapper<MemberVO>(MemberVO.class));

		 return memVO;
	}

}
