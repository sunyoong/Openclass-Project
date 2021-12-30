package com.icia.openclass.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.ApplyDTO;

@Repository
public class ApplyRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public void save(ApplyDTO apply) {
		sql.insert("apply.save", apply);
		
	}

	public List<ApplyDTO> findAll(long p_number) {
		return sql.selectList("apply.findAll", p_number);
	}
}
