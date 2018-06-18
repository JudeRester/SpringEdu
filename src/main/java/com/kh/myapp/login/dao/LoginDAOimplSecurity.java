package com.kh.myapp.login.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kh.myapp.login.vo.SecurityLoginVO;
import com.kh.myapp.member.vo.MemberVO;

public class LoginDAOimplSecurity implements UserDetailsService{
	
	@Autowired
	private JdbcTemplate jtemplate;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO memberVO;
		SecurityLoginVO loginVO;
		List<String> auth = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		str.append("select id, passwd, name, birth, phone, gender, cdate, udate from member where id= ?");
		
		memberVO = (MemberVO)this.jtemplate.queryForObject(str.toString(), new Object[] {username},
				new BeanPropertyRowMapper<>(MemberVO.class));
				
		if(memberVO == null) {
			throw new UsernameNotFoundException("사용자가 존재하지 않습니다.");
		}
		Set<GrantedAuthority> authorities = new HashSet<>();
		StringBuffer sql = new StringBuffer();
		sql.append("select role from user_role where id =?");
		auth = (ArrayList<String>)this.jtemplate.queryForList(sql.toString(), new Object[] {username}, String.class);
		for(String role : auth) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		loginVO = new SecurityLoginVO(memberVO.getId(), memberVO.getPasswd(), authorities);
		loginVO.setName(memberVO.getName());
		loginVO.setBirth(memberVO.getBirth());
		loginVO.setPhone(memberVO.getPhone());
		loginVO.setGender(memberVO.getGender());
		
		return loginVO;
	}

}
