package com.kh.myapp.login.vo;

import java.util.Collection;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Entity
@Data
public class SecurityLoginVO extends User{
	private String name;
	private String birth;
	private String phone;
	private String gender;
/*	private String username;
	private String password;
	//@Pattern(regexp="^[a-zA-Z0-9\\-_\\.]+@[a-zA-Z0-9\\-_\\.]+\\.[a-zA-Z]+$")
*/
	public SecurityLoginVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
	}
	private static final long serialVersionUID = 1L;
}
