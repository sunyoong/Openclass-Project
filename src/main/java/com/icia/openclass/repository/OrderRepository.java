package com.icia.openclass.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.openclass.dto.OrderDTO;

@Repository
public class OrderRepository {

	@Autowired
	private SqlSessionTemplate sql;


	public OrderDTO findById(long p_number) {
		OrderDTO orderResult = sql.selectOne("order.findById", p_number);
		return orderResult;
	}



	public void save(OrderDTO order) {
		sql.insert("order.save", order);
	}



	public OrderDTO findorder(long o_number) {
		return sql.selectOne("order.findorder", o_number);
	}



}
