package com.icia.openclass.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.openclass.dto.ApplyDTO;
import com.icia.openclass.dto.OrderDTO;
import com.icia.openclass.dto.ProductDTO;
import com.icia.openclass.service.ApplyService;
import com.icia.openclass.service.OrderService;
import com.icia.openclass.service.ProductService;

@Controller
@RequestMapping(value="/order/*")
public class OrderController {
	@Autowired
	private ProductService ps;
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private ApplyService as;
	
	// 클래스 신청& 결제
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@ModelAttribute OrderDTO order, Model model) {
	os.save(order);
	model.addAttribute("order", order);
	System.out.println(order.getO_payment());

	
	if(order.getO_payment().equals("card")) {
		return "order/card";
	} else {
		return "order/cash";	
	}
		 
	}
	
	
	@RequestMapping(value="cash-pay", method=RequestMethod.POST)
	public String cashPay(@ModelAttribute ApplyDTO apply, @RequestParam("p_number") long p_number, Model model) {
		// 해당 번호의 클래스에 신청인 number 업데이트?하고 dto 출력
		
		ps.apply(p_number);
		ProductDTO product =  ps.findById(p_number);
		
		// applyDTO에 신청인 정보 저장
		ApplyDTO apply1= new ApplyDTO();
		apply1.setM_number(product.getM_number());
		apply1.setP_number(product.getP_number());
		apply1.setM_id(product.getM_id());
		apply1.setA_applyNum(product.getP_applyNum());
		System.out.println("OrderController.apply1 : " + apply1);
		// 수강신청회원 저장
		as.save(apply1);
		// 수강신청회원 전체목록 리스트
		List<ApplyDTO> applyList = as.findAll(p_number);
		System.out.println("applyList: " + applyList);
		model.addAttribute("applyList", applyList);
		model.addAttribute("product", product);
		return "order/cash-pay";
	}
	
	
	
	
	
	
	
}