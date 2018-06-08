package com.kh.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@RestController //리소스(데이터) 자체를 반환하는데 사용(Json, XML, 문자열)
@Controller
@RequestMapping("/rest")

public class RestfullController {

	@Autowired
	@Qualifier("memberServiceimplXML")
	MemberService ms;
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
		
	}
	@RequestMapping(value="/member", method = RequestMethod.GET, produces = "application/json")
	public List<MemberVO> member(@RequestParam("id") String id) {
		List<MemberVO> list = new ArrayList<>();
		
		MemberVO memberVO = new MemberVO();
		memberVO = ms.getByMemberId(id);
		list.add(memberVO);
		
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setId("admin@kh.com");
		memberVO2.setPasswd("1234");
		list.add(memberVO2);
		
		return list;
	}
	@RequestMapping(value="/memberList", method=RequestMethod.GET)
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin@kh.com");
		memberVO.setPasswd("1234");
		memberVO.setName("홍길동");
		memberVO.setPhone("01012345678");
		list.add(memberVO);
		
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setId("admin2@kh.com");
		memberVO2.setPasswd("1234");
		memberVO2.setName("홍길동2");
		memberVO2.setPhone("01012345678");
		list.add(memberVO2);
		
		
		return list;
	}
	@RequestMapping("/memberMap")
	public Map<Integer, MemberVO> memberMap(){
		Map<Integer, MemberVO> map = new HashMap<>();
		for(int i =0; i<10; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setId("admin"+i+"@kh.com");
			mvo.setPasswd("1234");
			mvo.setName("홍길동"+i);
			mvo.setPhone("010-1234-567"+i);
			map.put(i+1, mvo);
		}
		return map;
	}
	@RequestMapping("/array")
	public String[] array() {
		String[] str = new String[] {"홍길동","홍길서","홍길남","홍길북"};
		return str;
	}
}
