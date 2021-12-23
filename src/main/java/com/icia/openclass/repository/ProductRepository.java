package com.icia.openclass.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.PageDTO;
import com.icia.openclass.dto.ProductDTO;

@Repository
public class ProductRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void save(ProductDTO product) {
		sql.insert("product.save", product);
		
	}

	public List<ProductDTO> findAll() {
		return sql.selectList("product.findAll");
	}

	public ProductDTO findById(long p_number) {
		return sql.selectOne("product.findById", p_number);
		
	}

	public void update(long p_number) {
		sql.update("product.update", p_number);
	}
	// 추천수
	public void recommend(long p_number) {
		sql.update("product.recommend", p_number);
		System.out.println("repository.result:");
		
		
	}

	public int boardCount() {
		return sql.selectOne("product.boardCount");
	}


	public List<ProductDTO> pagingList1(Map<String, Integer> pagingParam) {
		return sql.selectList("product.pagingList", pagingParam);
	}


}
