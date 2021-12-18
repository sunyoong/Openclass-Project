package com.icia.openclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.service.MemberService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	@Autowired
	private MemberService ms;
	// 회원가입 페이지로 이동
	 @RequestMapping(value="save", method=RequestMethod.GET)
	 public String saveform() { 
		 return "member/save";
		 }
	 
	 // 회원가입처리
	 @RequestMapping(value="save", method=RequestMethod.POST)
	 public String save(@ModelAttribute MemberDTO member, Model model) {
		 ms.save(member);
		 model.addAttribute("member", member);
		 System.out.println("멤버 컨트롤러에서 save.member : " + member);
		 return "/index";
	 }
	 
	 //회원목록
	 @RequestMapping(value="findAll", method=RequestMethod.GET)
	 public String findAll(Model model) {
		 List<MemberDTO> memberList = ms.findAll();
		 model.addAttribute("memberList", memberList);
		 return "member/findAll";
	 }
	 
	 
	 //회원정보 삭제
	 @RequestMapping(value="delete", method=RequestMethod.GET)
	 public String delete() {
		 return "member/findAll";
	 }
	 
	
}
