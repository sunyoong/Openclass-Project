package com.icia.openclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.openclass.dto.OrderDTO;
import com.icia.openclass.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository or;


	@Override
	public OrderDTO findById(long p_number) {
		return or.findById(p_number);
	}


	@Override
	public void save(OrderDTO order) {
		or.save(order);
		
	}


	@Override
	public OrderDTO findorder(long o_number) {
		OrderDTO findOrder = or.findorder(o_number);
		return findOrder;
	}




	
	
}
