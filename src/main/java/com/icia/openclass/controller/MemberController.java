package com.icia.openclass.controller;


import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.protobuf.Message;
import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.dto.MentorSaveDTO;
import com.icia.openclass.dto.PageDTO;
import com.icia.openclass.service.MemberService;
import com.icia.openclass.service.MentorService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@Autowired
	private MentorService mes; // 멘토
	
	//페이징처리
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		PageDTO paging = ms.paging(page);
		List<MemberDTO> memberList = ms.pagingList(page);
		model.addAttribute("paging", paging);
		model.addAttribute("memberList", memberList);
		return "member/findAll";
	}

	// 회원가입 페이지로 이동
	@RequestMapping(value = "save", method = RequestMethod.GET)
	public String saveform() {
		return "member/save";
	}

	// 아이디 중복확인
	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public @ResponseBody String idCheck(@RequestParam("m_id") String m_id) {
		String result = ms.idCheck(m_id);
		System.out.println("member.controller/idCheck :" + m_id + "result : " + result);
		return result;
	}
	
	

	// 회원가입처리
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute MemberDTO member, Model model) {
		ms.save(member);
		model.addAttribute("member", member);
		System.out.println("멤버 컨트롤러에서 save.member : " + member);
		return "/index";
	}

	// 로그인 화면요청
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginform() {
		return "member/login";
	}

	// 로그인처리

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO member) {
		// 멘토인지 일반회원인지 구분 필요함
		MentorSaveDTO mentor = mes.findById(member.getM_id());
		if(mentor!=null) {
			return "mentor/index";
		}else {
			String result = ms.login(member);
			System.out.println("Controller.login");
			return result;
		}
		
	}

	
	// 로그아웃
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
		
	}
	
	
	// 회원목록
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<MemberDTO> memberList = ms.findAll();
		model.addAttribute("memberList", memberList);
		return "member/findAll";
	}

	// 회원정보 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("m_number") long m_number) {
		ms.delete(m_number);
		return "redirect:/member/paging";
	}
	
	// 마이페이지 화면 요청
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String myPage() {
		return "member/mypage";
	}
	
	// 내정보 수정 : 기존정보 불러온 화면 요청
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateForm(@RequestParam("m_number") long m_number, Model model) {
		MemberDTO member = ms.findById(m_number);
		model.addAttribute("member", member);
		return "member/update";
	}

	// 내정보 수정 : 수정처리
		@RequestMapping(value = "update", method = RequestMethod.POST)
		public String update(@ModelAttribute MemberDTO member) {
			ms.update(member);
			return "member/mypage";
		}

	// member.update에서 비밀번호 일치여부
		@RequestMapping(value="pwResult", method=RequestMethod.POST)
		public @ResponseBody String pwResult(@RequestParam("m_password") String m_password) {
			String result=  ms.pwResult(m_password);
			return result;
		}

		
		//admin페이지 
		@RequestMapping(value="admin", method=RequestMethod.GET)
		public String admin() {
			return "/admin/index";
		}
		
		

		
		
}
