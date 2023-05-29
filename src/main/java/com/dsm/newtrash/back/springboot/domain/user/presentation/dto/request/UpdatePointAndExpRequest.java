package com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request;

import jakarta.validation.constraints.Max;
import lombok.Getter;

@Getter
public class UpdatePointAndExpRequest {

	@Max(value = 30)
	private int correctAnswer;

	@Max(value = 30)
	private int totalProblem;

}
