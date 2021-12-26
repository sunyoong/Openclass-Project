package com.icia.openclass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.openclass.dto.OrderDTO;
import com.icia.openclass.dto.ProductDTO;
import com.icia.openclass.service.OrderService;
import com.icia.openclass.service.ProductService;

@Controller
@RequestMapping(value="/order/*")
public class OrderController {
	@Autowired
	private ProductService ps;
	
	@Autowired
	private OrderService os;
	
	// 클래스 신청& 결제
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@ModelAttribute OrderDTO order, @RequestParam("m_number") long m_number, Model model) {
	os.save(order);
	model.addAttribute("order", order);
	if(order.getO_payment()== "card") {
		return "order/card";
	} else {
		return "order/cash";	
	}
		 
	}
	
	
	@RequestMapping(value="cash-pay", method=RequestMethod.POST)
	public String cashPay(@RequestParam("p_number") long p_number, Model model) {
		ps.apply(p_number);
		ProductDTO product =  ps.findById(p_number);
		model.addAttribute("product", product);
		return "order/cash-pay";
	}
	
	
}