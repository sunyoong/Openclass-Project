package com.icia.openclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index(@RequestParam("p_number") long p_number, Model model) {
		os.findById(p_number);
//		이거 order은 결제 정보를 담는 DTO잖아요
//		그니까 order을 불러 오는게 아니고 order안에 필요한 정보를 가져와야해요 그니까
//		product의 정보를 가져와서 홈페이지에 출력을 하고 홈페이지에서 그 값으로 보여주는거고
//		
//		밑에 payment에서 결제를 진행하고 order테이블을 저장하는거죠
//		그런데 그 order.jsp에서 o_number가 필요한 것 같아서 order로 불러와야 하는건가 했던건데
//		ajax해서 payment진행할때.
		return "order/order";
	}
	
	

	
	@RequestMapping(value="payment", method=RequestMethod.POST)
	public OrderDTO save(@ModelAttribute OrderDTO order, @RequestParam("p_number") long p_number) {
		 os.save(order);
		 OrderDTO findorder = os.findorder(order.getO_number());
		 System.out.println(findorder);
		return findorder;
	}
	
	
	
	
	
}