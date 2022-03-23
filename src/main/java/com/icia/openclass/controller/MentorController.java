package com.icia.openclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icia.openclass.dto.MentorSaveDTO;
import com.icia.openclass.service.MentorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentor/")
public class MentorController {
	private final MentorService ms;
	
	@GetMapping("save")
	public String mentorSaveForm() {
		return "mentor/save";
	}

	@PostMapping("save/")
	public String mentorSave(@ModelAttribute MentorSaveDTO mentorSaveDTO) {
		ms.save(mentorSaveDTO);
		return "index";
	}
	
}
