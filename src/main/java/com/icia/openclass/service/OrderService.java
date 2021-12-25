package com.icia.openclass.service;

import com.icia.openclass.dto.OrderDTO;

public interface OrderService {


	OrderDTO findById(long p_number);

	void save(OrderDTO order);

	OrderDTO findorder(long o_number);











}
