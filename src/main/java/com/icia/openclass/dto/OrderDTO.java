package com.icia.openclass.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderDTO {
	private long o_number;
	private long p_number;
	private long m_number;
	private String m_id;
	private String p_name;
	private long p_price;
	private String o_payment;
	private Date datetime;
	
	// 은행, 현금영수증 유무 
	private String o_bank;
	private boolean o_cashrept;
}
