package com.icia.openclass.service;

import java.util.List;

import com.icia.openclass.dto.ApplyDTO;

public interface ApplyService {

	void save(ApplyDTO apply);

	List<ApplyDTO> findAll(long p_number);

}
