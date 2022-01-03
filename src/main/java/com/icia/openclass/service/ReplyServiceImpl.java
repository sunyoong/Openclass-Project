package com.icia.openclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.openclass.dto.ReplyDTO;
import com.icia.openclass.repository.ReplyRepository;
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyRepository rr;
	// 댓글저장
	@Override
	public void save(ReplyDTO reply) {
		System.out.println("replyService.save");
		rr.save(reply);
		
		
	}
	@Override
	public List<ReplyDTO> findAll(long p_number) {
		return rr.findAll(p_number);
	}
	@Override
	public void delete(long r_number) {
		rr.delete(r_number);
		
	}

}
