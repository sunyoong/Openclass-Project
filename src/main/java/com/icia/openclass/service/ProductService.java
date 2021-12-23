package com.icia.openclass.service;

import java.util.List;

import com.icia.openclass.dto.PageDTO;
import com.icia.openclass.dto.ProductDTO;

public interface ProductService {
	
	void save(ProductDTO product);
	
	// 전체목록조회
	List<ProductDTO> findAll();

	// 상세조회
	ProductDTO findById(long p_number);

	void update(long p_number);

	void recommend(long p_number);

	// 페이징 처리 : 페이지
	PageDTO paging(int page);
	// 페이징 처리 : 페이지 리스트를 상품 리스트에 추가.

	List<ProductDTO> pagingList(int page);
	

}
