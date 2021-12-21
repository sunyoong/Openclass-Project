package com.icia.openclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.dto.PageDTO;
import com.icia.openclass.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository mr;
	
	@Autowired
	private HttpSession session;
	
	// 페이징처리
	private static final int PAGE_LIMIT = 5; // 한 화면에 보여질 글 개수
	private static final int BLOCK_LIMIT = 5; // 한 화면에 보여질 페이지 개수
	
	@Override
	public List<MemberDTO> pagingList(int page) {
		int pagingStart = (page-1) * PAGE_LIMIT;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		List<MemberDTO> pagingList = mr.pagingList1(pagingParam);
		for(MemberDTO m : pagingList) {
			System.out.println(m.toString());
		}
		return pagingList;
	}
	
	//페이징
		@Override
		public PageDTO paging(int page) {
			int boardCount = mr.boardCount();
			int maxPage = (int)(Math.ceil((double)boardCount/PAGE_LIMIT));
			int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT)))-1) * BLOCK_LIMIT + 1;
			int endPage = startPage + BLOCK_LIMIT -1;
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			PageDTO paging = new PageDTO();
			paging.setPage(page);
			paging.setMaxPage(maxPage);
			paging.setStartPage(startPage);
			paging.setEndPage(endPage);
			
			System.out.println("paging.toString() : " + paging.toString());
			return paging;
		
		}
	
	
	// 회원가입
		@Override
		public void save(MemberDTO member) {
			mr.save(member);
			
		}

	
	// 아이디 중복체크
	@Override
	public String idCheck(String m_id) {
		String result = mr.idCheck(m_id);
		if(result != null) {
			return "o";
		} else{
			return "x";
		}
	}
	
	
	
	// 전체회원조회 
	@Override
	public List<MemberDTO> findAll() {
		return mr.findAll();
	}

	// 로그인처리
	@Override
	public String login(MemberDTO member) {
		MemberDTO loginUser = mr.login(member);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("loginId", loginUser.getM_id());
			session.setAttribute("memberNum", loginUser.getM_number());
			System.out.println("서비스임플에서 login된 회원정보 :" + loginUser);
			System.out.println("member.getM_number() : " + member.getM_number());
			return "index";
		} else {
			return "member/login";
		}
	}

	// 회원 삭제
	@Override
	public void delete(long m_number) {
		mr.delete(m_number);
		
	}

	// 정보 수정을 위한 기존정보 조회
	@Override
	public MemberDTO findById(long m_number) {
		MemberDTO member = mr.findById(m_number);
		return member;
	}

	// 정보 수정처리
	@Override
	public void update(MemberDTO member) {
		mr.update(member);
		
	}

	// 비밀번호 일치여부
	@Override
	public String pwResult(String m_password) {
		String result = mr.pwResult(m_password);
		if(result != null) {
			return "o";
		} else {
			return "x";
		}
	}


	



}
