package com.icia.openclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.openclass.dto.ApplyDTO;
import com.icia.openclass.repository.ApplyRepository;

@Service
public class ApplyServiceImpl implements ApplyService{

	@Autowired
	private ApplyRepository ar;

	@Override
	public void save(ApplyDTO apply) {
		ar.save(apply);
		
	}
	// 전체조회
	@Override
	public List<ApplyDTO> findAll(long p_number) {
		List<ApplyDTO> applyList = ar.findAll(p_number);
		return applyList;
	}
}
