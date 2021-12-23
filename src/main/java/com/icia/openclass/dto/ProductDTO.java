package com.icia.openclass.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductDTO {
	private long p_number; // 클래스 번호
	private long m_number; // 회원번호
	private String m_id; // 작성자
	private String p_name; // 클래스이름
	private String p_contents; // 클래스 내용
	private long p_price; // 클래스 가격
	private Date p_startDate; // 클래스 시작일, 최신순
	private Date p_endDate; // 클래스 종료일
	private int p_hits; // 조회수
	private long p_discount; // 할인율
	
	
	
	private int p_satisfy; // 강의만족도 ( 만족/불만족 int로)
	private int p_resisNum; // 인기순
	private int p_recommend; // 추천순
	
}
