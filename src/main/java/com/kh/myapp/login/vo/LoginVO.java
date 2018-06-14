package com.kh.myapp.login.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class LoginVO {
	private String username;
	@Pattern(regexp="^[a-zA-Z0-9\\-_\\.]+@[a-zA-Z0-9\\-_\\.]+\\.[a-zA-Z]+$")
	private String password;
}
