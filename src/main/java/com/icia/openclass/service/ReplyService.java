package com.icia.openclass.service;

import java.util.List;

import com.icia.openclass.dto.ReplyDTO;

public interface ReplyService {

	void save(ReplyDTO reply);

	List<ReplyDTO> findAll(long p_number);



}
