package com.icia.openclass.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.ReplyDTO;

@Repository
public class ReplyRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public void save(ReplyDTO reply) {
		System.out.println("replyRepository.save");
		sql.insert("reply.save", reply);
	}

	public List<ReplyDTO> findAll(long p_number) {
		
		return sql.selectList("reply.findAll", p_number);
	}

}
