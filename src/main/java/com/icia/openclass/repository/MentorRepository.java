package com.icia.openclass.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.MentorSaveDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MentorRepository {
	private final SqlSessionTemplate sql;
	
// 멘토가입
	public void save(MentorSaveDTO mentorSaveDTO) {
		sql.insert("mentor.save", mentorSaveDTO);
		
	}

	
}
