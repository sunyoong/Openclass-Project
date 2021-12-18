package com.icia.openclass.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.MemberDTO;
@Repository
public class MemberRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void save(MemberDTO member) {
		sql.insert("member.save", member);
		
	}

	public List<MemberDTO> findAll() {
		
		return sql.selectList("member.findAll");
	}

}
