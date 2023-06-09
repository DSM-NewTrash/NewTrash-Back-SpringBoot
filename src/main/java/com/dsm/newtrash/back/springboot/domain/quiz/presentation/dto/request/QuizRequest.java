package com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.request;

import java.util.List;

import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.request.ProblemRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class QuizRequest {

	@NotBlank(message = "입력해주세요.")
	@Size(max = 15, message = "15자 이하로 입력해주세요.")
	private String title;

	@NotBlank(message = "입력해주세요.")
	@Size(max = 30, message = "30자 이하로 입력해주세요.")
	private String introduction;

	private String path;

	@NotBlank(message = "입력해주세요.")
	private String category;

	@Valid
	@NotNull(message = "입력해주세요.")
	@Size(min = 5, max = 30, message = "5개 이상 30개 이하로 입력해주세요.")
	List<ProblemRequest> problems;


}
