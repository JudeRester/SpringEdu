package com.kh.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


	@RequestMapping("/")
	public String main(){
		return "index";
	}
	@RequestMapping("/login")
	public String securityLogIn(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.getPrincipal().equals("anonymousUser")) {
			return "redirect:/";
		}
		return "login/login";
	}
	
}
