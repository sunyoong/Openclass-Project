package com.icia.openclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.openclass.dto.ReplyDTO;
import com.icia.openclass.service.ReplyService;


@Controller
@RequestMapping(value="/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService rs;
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@RequestParam("p_number") long p_number, @RequestParam(value="page", required=false, defaultValue="1") int page, @ModelAttribute ReplyDTO reply, Model model) {
		rs.save(reply);
		List<ReplyDTO> replyList = rs.findAll(reply.getP_number());
		model.addAttribute("replyList", replyList);
		System.out.println("replyController.save에서 replyList" + replyList);
		
		return "redirect:/product/detail?p_number=" + p_number + "&page=" + page;
	}
	
	// 댓글삭제
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@ModelAttribute ReplyDTO reply, @RequestParam(value="page", required=false, defaultValue="1") int page, @RequestParam("p_number") long p_number, @RequestParam("r_number") long r_number) {
		System.out.println(reply);
		rs.delete(r_number);
		
		return "redirect:/product/detail?p_number=" + p_number + "&page=" + page;
	}
	
	
	
	
}
