package com.kh.myapp.login.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Entity
public class LoginVO {
	private String id;
	private String passwd;
	
	@Pattern(regexp="^[a-zA-Z0-9\\-_\\.]+@[a-zA-Z0-9\\-_\\.]+\\.[a-zA-Z]+$")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
