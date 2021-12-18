package com.icia.openclass.service;

import java.util.List;

import com.icia.openclass.dto.MemberDTO;

public interface MemberService {
	//회원가입
	void save(MemberDTO member);

	List<MemberDTO> findAll();
	
}
