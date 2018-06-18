package com.kh.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.login.vo.SecurityLoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping("/login")
//@SessionAttributes("login")
public class LoginController {
		
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	@Qualifier("loginServiceimplJDBC")
	LoginService loginService;
	
	@RequestMapping("/login")
	public String securityLogIn(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.getPrincipal().equals("anonymousUser")) {
			logger.info("인증"+auth.getPrincipal());
			return "redirect:/";
		}
		return "login/login";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/";
	}
	
	//로그인 화면
	@RequestMapping("/loginIn")
	public String logIn(Model model, HttpSession session) {
		if(session.getAttribute("login")!=null) {
			return "redirect:/";
		}
		model.addAttribute("login", new LoginVO());
		return "login/login";
	}
	//로그인 처리
	@RequestMapping("/memLoginOK")
	public String memLoginOK(@ModelAttribute("login") @Valid LoginVO login, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "login/login";
		}
	
	// 회원정보 가져오기
	MemberVO memberVO = loginService.getMember(login);
	if (memberVO != null) {
		// 회원정보 세션에 담기
		model.addAttribute("login", memberVO);
		return "redirect:/";

	} else {
		return "login/login";
	}
}
	//로그아웃
	@RequestMapping("/logOut")
//	public String logOut(@ModelAttribute("login") MemberVO login, SessionStatus sessionStatus) {
	public String logOut(LoginVO logout, SessionStatus sessionStatus) {
		sessionStatus.setComplete();		
		return "redirect:/";
	}
	
	
}
