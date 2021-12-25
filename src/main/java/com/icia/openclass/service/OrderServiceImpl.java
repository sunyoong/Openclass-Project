package com.icia.openclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.openclass.dto.OrderDTO;
import com.icia.openclass.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository or;

	@Override
	public void save(OrderDTO order) {
		 or.save(order);
	}

	@Override
	public OrderDTO findById(long o_number) {
		return or.findById(o_number);
		


	}


}



	
	

