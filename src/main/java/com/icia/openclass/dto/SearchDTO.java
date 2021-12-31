package com.icia.openclass.dto;

import lombok.Data;

@Data
public class SearchDTO {
	private int pagingStart;
	private int PAGE_LIMIT;
	private String keyword;
	private String searchType;
}
