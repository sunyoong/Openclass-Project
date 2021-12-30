package com.icia.openclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.openclass.dto.ApplyDTO;
import com.icia.openclass.dto.ProductDTO;
import com.icia.openclass.service.ApplyService;
import com.icia.openclass.service.ProductService;

@Controller
@RequestMapping(value="/apply/*")
public class ApplyController {
	@Autowired
	private ApplyService as;
	
	@Autowired
	private ProductService ps;
	
	@RequestMapping(value="applymember", method=RequestMethod.GET)
	public String applyMem(Model model, @RequestParam("p_number") long p_number) {
		ProductDTO product = ps.findById(p_number);
		List<ApplyDTO> applyList = as.findAll(p_number);
		System.out.println("applyController.applylist : " + applyList);
		model.addAttribute("applyList", applyList);
		model.addAttribute("product", product);
		return "product/applymember";
		
		
		
	}
}
