package com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class UpdatePointAndExpRequest {

	@NotNull(message = "입력해주세요.")
	private Long id;

	@NotNull(message = "입력해주세요.")
	private Long correctAnswer;

}
