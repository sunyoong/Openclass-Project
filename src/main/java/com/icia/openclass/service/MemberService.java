package com.icia.openclass.service;

import java.util.List;

import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.dto.PageDTO;

public interface MemberService {
	// 페이징처리
	PageDTO paging(int page);
	// 페이징리스트
	List<MemberDTO> pagingList(int page);
	// 회원가입
	void save(MemberDTO member);
	// 전체회원목록 조회
	List<MemberDTO> findAll();
	// 아이디 중복체크
	String idCheck(String m_id);
	// 로그인처리
	 String login(MemberDTO member);
	// 회원삭제
	void delete(long m_number);
	// 정보 수정을 위한 기존 정보 조회
	MemberDTO findById(long m_number);
	// 정보수정처리
	void update(MemberDTO member);
	// 정보수정 페이지에서 비밀번호 일치여부
	String pwResult(String m_password);
	

	
}
