package com.icia.openclass.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberDTO {
	private long m_number;
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
	private String m_phone;
	private Date m_joindate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime m_pwdate;
	
}
