package com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProblemRequest {

	@NotBlank(message = "입력해주세요.")
	private String form;

	@NotBlank(message = "입력해주세요.")
	@Size(max = 30, message = "30자 이하로 입력해주세요.")
	private String question;

	@Max(value = 5)
	private int correctAnswer;

	@NotBlank(message = "입력해주세요.")
	@Size(max = 50, message = "50자 이하로 입력해주세요.")
	private String explanation;

	@NotBlank(message = "입력해주세요.")
	private String path;

	@Valid
	private List<AnswerRequest> answers;

}
