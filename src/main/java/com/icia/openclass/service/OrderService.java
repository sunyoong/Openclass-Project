package com.icia.openclass.service;


import com.icia.openclass.dto.OrderDTO;

public interface OrderService {


	OrderDTO findById(long o_number);

	void save(OrderDTO order);
	
	// 주문내역 삭제
	void delete(long p_number);






}
