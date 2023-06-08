package com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizResponses {

	private final int totalQuiz;
	private final List<QuizResponse> quizResponses;

	@Getter @Builder
	public static class QuizResponse {
		private final Long id;
		private final String image;
		private final String title;
		private final String introduction;
		private final String category;
		private final int starRating;
		private final String writer;
		private final boolean isCertificate;
		private final int totalProblem;
	}

}
