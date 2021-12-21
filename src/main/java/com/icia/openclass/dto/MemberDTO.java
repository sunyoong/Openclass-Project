package com.icia.openclass.dto;

import java.sql.Date;
import java.time.LocalDateTime;

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
	private LocalDateTime m_pwdate;
	
}
