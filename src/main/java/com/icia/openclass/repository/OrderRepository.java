package com.icia.openclass.repository;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.OrderDTO;

@Repository
public class OrderRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public void save(OrderDTO order) {
		sql.insert("order.save", order);
		
	}

	public OrderDTO findById(long o_number) {
		return sql.selectOne("order.findById", o_number);
	}

	public void delete(long p_number) {
		sql.delete("order.delete", p_number);
		
	}














}
