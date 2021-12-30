package com.icia.openclass.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.MemberDTO;
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

	public void updateHits(long p_number) {
		sql.update("product.updateHits", p_number);
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

	public void product(long p_number) {
		
	}

	public int ratingResult(long p_number) {
		return sql.selectOne("product.ratingResult", p_number);
	}

	public int applyNum(long p_number) {
		return sql.selectOne("product.applyNum", p_number);
	}


	public void rating(ProductDTO product) {
		sql.update("product.rating", product);
		
	}

	public void apply(long p_number) {
		sql.update("product.apply", p_number);
		
	}
	// 게시글 삭제
	public void delete(long p_number) {
		sql.delete("product.delete", p_number);
		
	}
	//클래스 수정처리
	public void update(ProductDTO product) {
		sql.update("product.update", product);
		
	}

	public List<ProductDTO> applymember(long p_number) {
		return sql.selectList("product.applymember", p_number);
	}

	public List<ProductDTO> selectList(String select) {
		return sql.selectList("product.select", select);
	}

	


}
