package com.icia.openclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorSaveDTO {
	private Long me_number; // 멘토번호(pk)
	private String me_id; // 아이디
	private String me_password; // 비밀번호
	private String me_name; // 이름
	private String me_phone; // 휴대폰

}
