package com.kh.myapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
		
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	@Qualifier("loginServiceimplJDBC")
	LoginService loginService;
	
	//로그인 화면
	@RequestMapping("/loginIn")
	public String logIn(Model model) {
		model.addAttribute("user", new MemberVO());
		return "login/login";
	}
	//로그인 처리
	@RequestMapping("/memLoginOK")
	public String memLoginOK(@Valid @ModelAttribute MemberVO user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "login/login";
		}
		
		//회원정보 세션에 담기
		return "redirect:/";
	}
	//로그아웃
	@RequestMapping("/logout")
	public String logOut(@ModelAttribute("user") MemberVO user, SessionStatus sessionStatus) {
		sessionStatus.setComplete();		
		return "redirect:/";
	}
	
}
