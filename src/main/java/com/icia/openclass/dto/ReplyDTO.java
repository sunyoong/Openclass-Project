package com.icia.openclass.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyDTO {
	private long r_number; // 댓글번호(임의)
	private long p_number; // 게시글번호
	private long m_number; // 회원번호
	private String m_id;// 회원아이디
	private String r_contents; // 댓글내용
	private Date r_date; // 댓글작성일
	
}
