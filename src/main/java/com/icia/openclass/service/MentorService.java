package com.icia.openclass.service;

import com.icia.openclass.dto.MentorSaveDTO;

public interface MentorService {

	void save(MentorSaveDTO mentorSaveDTO);

	MentorSaveDTO findById(String m_id); // 입력받은 아이디로 멘토 아이디 찾기

}
