package com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {

	@NotBlank(message = "입력해주세요.")
	@Size(max = 20, message = "20자 이하로 입력해주세요.")
	private String answer;

}
