package com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyQuizResponses {

	private final int totalQuiz;
	private final List<QuizResponse> quizResponses;

	@Getter @Builder
	public static class QuizResponse {
		private final Long id;
		private final String image;
		private final String title;
		private final String introduction;
		private final String category;
	}

}
