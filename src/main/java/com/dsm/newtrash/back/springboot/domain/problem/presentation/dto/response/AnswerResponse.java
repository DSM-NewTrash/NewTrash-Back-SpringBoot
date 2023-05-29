package com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerResponse {

	private final Long id;
	private final String answer;

}
