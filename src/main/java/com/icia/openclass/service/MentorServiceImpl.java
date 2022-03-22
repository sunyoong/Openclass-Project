package com.icia.openclass.service;

import org.springframework.stereotype.Service;

import com.icia.openclass.dto.MentorSaveDTO;
import com.icia.openclass.repository.MentorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {
	private final MentorRepository mr;
	
	public void save(MentorSaveDTO mentorSaveDTO) {
		mr.save(mentorSaveDTO);
		
	}
	

	
	
	
}
