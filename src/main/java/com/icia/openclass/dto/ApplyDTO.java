package com.icia.openclass.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ApplyDTO {
	private long a_number; // 수강신청회원 임의숫자
	private long p_number; // 게시글번호
	private long m_number; // 회원번호
	private String m_id; // 회원아이디
	private long a_applyNum; // 수강신청 회원인원수
	private Date a_date; // 수강신청한 날짜
}
