package com.icia.openclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.openclass.dto.ReplyDTO;
import com.icia.openclass.service.ReplyService;


@Controller
@RequestMapping(value="/reply/*")
public class ReplyController {
	
	@Autowired
	private ReplyService rs;
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public @ResponseBody List<ReplyDTO> save(@ModelAttribute ReplyDTO reply, Model model) {
		rs.save(reply);
		List<ReplyDTO> replyList = rs.findAll(reply.getP_number());
		model.addAttribute("replyList", replyList);
		System.out.println("replyController.save에서 replyList" + replyList);
		return replyList;
	}
}
