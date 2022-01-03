package com.icia.openclass.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.dto.PageDTO;
@Repository
public class MemberRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	// 회원가입처리
	public int save(MemberDTO member) {
		System.out.println("member.repository/save : ");
		return sql.insert("member.save", member);
		
	}
	//회원 전체목록 조회
	public List<MemberDTO> findAll() {
		return sql.selectList("member.findAll");
	}
	public String idCheck(String m_id) {
		return sql.selectOne("member.idCheck", m_id);
	}
	
	// 로그인
	public MemberDTO login(MemberDTO member) {
		System.out.println("member.repository/login: " + member);
		return sql.selectOne("member.login", member);

	}
	// 회원삭제
	public void delete(long m_number) {
		sql.delete("member.delete", m_number);
		
	}
	//회원목록 페이징 리스트
	public List<MemberDTO> pagingList1(Map<String, Integer> pagingParam) {
		return sql.selectList("member.pagingList1", pagingParam) ;
	}
	//회원목록개수
	public int boardCount() {
		return sql.selectOne("member.count");
	}
	public MemberDTO findById(long m_number) {
		return sql.selectOne("member.findById", m_number);
		
	}
	public void update(MemberDTO member) {
		sql.update("member.update", member);
		
	}
	// 비밀번호 확인
		public String pwResult(String m_password) {
			return sql.selectOne("member.pwResult", m_password);
		}
		public List<MemberDTO> applymember(long p_number) {
			
			return sql.selectList("member.applymember", p_number);
		}
		


	
	
	

}
