package com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;

@Getter
@Validated
public class SolveQuizRequests {

	@NotNull
	private List<@Valid SolveQuizRequest> solveQuizs;

	@Getter
	public static class SolveQuizRequest {

		@NotNull(message = "입력해주세요.")
		private Long id;

		@NotNull(message = "입력해주세요.")
		private Long correctAnswer;

	}

}
