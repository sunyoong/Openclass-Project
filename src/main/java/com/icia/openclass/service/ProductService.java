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

	void updateHits(long p_number);

	void recommend(long p_number);

	// 페이징 처리 : 페이지
	PageDTO paging(int page);
	// 페이징 처리 : 페이지 리스트를 상품 리스트에 추가.

	List<ProductDTO> pagingList(int page);

	// 만족도 합계 저장

	void rating(ProductDTO product);

	// 평점합계
	int ratingResult(long p_number);

	int applyNum(long p_number);
	//수강신청 인원수저장
	void apply(long p_number);
	// 클래스 삭제
	void delete(long p_number);

	void update(ProductDTO product);
	// 수강신청한 회원목록(클래스별로)
	List<ProductDTO> applymember(long p_number);

	List<ProductDTO> selectList(String select);

	List<ProductDTO> search(String searchType, String keyword);

	

}
