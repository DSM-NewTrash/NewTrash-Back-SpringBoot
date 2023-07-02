package com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProblemExplanationResponses {

	private final List<ProblemResponse> problemResponses;

	@Getter @Builder
	static public class ProblemResponse {

		private final Long id;
		private final String form;
		private final String question;
		private final long correctAnswer;
		private final long userAnswer;
		private final String image;
		private final List<AnswerResponse> answers;
		private final String explanation;

	}

}
