package com.icia.openclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository mr;
	// 회원가입
	@Override
	public void save(MemberDTO member) {
		mr.save(member);
		
	}
	// 내정보조회 
	@Override
	public List<MemberDTO> findAll() {
		return mr.findAll();
	}
	
}
