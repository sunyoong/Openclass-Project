package com.icia.openclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.openclass.dto.MemberDTO;
import com.icia.openclass.dto.PageDTO;
import com.icia.openclass.dto.ProductDTO;
import com.icia.openclass.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository pr;
	
	@Override
	public void save(ProductDTO product) {
		pr.save(product);
		
	}


	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> productList = pr.findAll();
		return productList;
	}

	// 상세조회
	@Override
	public ProductDTO findById(long p_number) {
		ProductDTO product = pr.findById(p_number);
		return product;
	}

	// 조회수
	@Override
	public void updateHits(long p_number) {
		pr.updateHits(p_number);
		
	}

	// 추천수
	@Override
	public void recommend(long p_number) {
		pr.recommend(p_number);
		
	}

	private static final int PAGE_LIMIT = 5; // 한 페이지에 글개수
	private static final int BLOCK_LIMIT = 5;// 한 화면에 페이지개수
	
	// 페이징처리 
	@Override
	public PageDTO paging(int page) {
		int boardCount = pr.boardCount();
		int maxPage = (int)(Math.ceil((double)boardCount/PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT)))-1) * BLOCK_LIMIT +1;
		int endPage = startPage + BLOCK_LIMIT -1;
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		return paging;
	}

	// 페이징처리(리스트)
	@Override
	public List<ProductDTO> pagingList(int page) {
		int pagingStart = (page-1) * PAGE_LIMIT; // 페이지에서 시작하는 번호?
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		List<ProductDTO> productList = pr.pagingList1(pagingParam);
		System.out.println("productService.productList : " + productList);
		return productList;
	}

	// 만족도 합계 저장
	@Override
	public void rating(ProductDTO product) {
		System.out.println(product);
		pr.rating(product);
		
		
	}

	// 평점합계
	@Override
	public int ratingResult(long p_number) {
		int result = pr.ratingResult(p_number);
		return result;
	}

	// 수강신청인원
	@Override
	public int applyNum(long p_number) {
		return pr.applyNum(p_number);
	}

	// 수강신청 인원저장
	@Override
	public void apply(long p_number) {
		pr.apply(p_number);
	}

	// 클래스 삭제
	@Override
	public void delete(long p_number) {
		pr.delete(p_number);
		
	}

	// 수정처리
	@Override
	public void update(ProductDTO product) {
		pr.update(product);
	}

	// 수강신청한 회원목록
	@Override
	public List<ProductDTO> applymember(long p_number) {
		List<ProductDTO> applyList = pr.applymember(p_number);
		return applyList;
	}



	// 조회수,인기순... 목록정렬
	@Override
	public List<ProductDTO> selectList(String select) {
		List<ProductDTO> selectList = pr.selectList(select);
		System.out.println("productServiceImple.selectList : " + selectList);
		
		
		
		
		return selectList;
		
	}

	// 검색
	@Override
	public List<ProductDTO> search(String searchType, String keyword) {
		Map<String, String> searchList = new HashMap<String, String>();
		searchList.put("type", searchType);
		searchList.put("word", keyword);
		List<ProductDTO> searchResult = pr.search(searchList);
		return searchResult;
	}




	
	

}
