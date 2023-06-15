package com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProblemRequest {

	@NotBlank(message = "입력해주세요.")
	private String form;

	@NotBlank(message = "입력해주세요.")
	@Size(max = 30, message = "30자 이하로 입력해주세요.")
	private String question;

	@Max(value = 5)
	@NotNull(message = "입력해주세요.")
	private Integer correctAnswer;

	@NotBlank(message = "입력해주세요.")
	@Size(max = 50, message = "50자 이하로 입력해주세요.")
	private String explanation;

	private String path;

	@Valid
	private List<AnswerRequest> answers;

}
