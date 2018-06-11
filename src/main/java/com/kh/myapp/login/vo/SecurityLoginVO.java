package com.kh.myapp.login.vo;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class SecurityLoginVO {
	private String username;
	private String password;
	
	//@Pattern(regexp="^[a-zA-Z0-9\\-_\\.]+@[a-zA-Z0-9\\-_\\.]+\\.[a-zA-Z]+$")

	
}
