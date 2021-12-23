package com.icia.openclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	@Override
	public void update(long p_number) {
		pr.update(p_number);
		
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
		int pagingStart = (page-1) * PAGE_LIMIT +1;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		List<ProductDTO> productList = pr.pagingList1(pagingParam);
		return productList;
	}
	
	

}
