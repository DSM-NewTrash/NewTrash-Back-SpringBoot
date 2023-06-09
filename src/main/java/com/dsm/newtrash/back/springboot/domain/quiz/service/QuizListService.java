package com.dsm.newtrash.back.springboot.domain.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.problem.domain.repository.ProblemRepository;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.Quiz;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.repository.QuizRepository;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.type.CategoryType;
import com.dsm.newtrash.back.springboot.domain.quiz.exception.QuizBadRequestException;
import com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.response.QuizResponses;
import com.dsm.newtrash.back.springboot.global.aws.S3Util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizListService {

	private final QuizRepository quizRepository;
	private final ProblemRepository problemRepository;
	private final S3Util s3Util;


	@Transactional(readOnly = true)
	public QuizResponses getQuizs(String option, String category, boolean auth) {
		List<Quiz> quizs = new ArrayList<>();

		if(option.equals("RECENCY")) {
			if(category == null) quizs = quizRepository.findAllByOrderByIdDesc();
			else quizs = quizRepository.findAllByCategoryOrderByIdDesc(CategoryType.valueOf(category));
		}else if(option.equals("GOOD")) {
			if(category == null) quizs = quizRepository.findAllByOrderByStarDesc();
			else quizs = quizRepository.findAllByCategoryOrderByStarDesc(CategoryType.valueOf(category));
		} else throw QuizBadRequestException.EXCEPTION;

		List<QuizResponses.QuizResponse> quizResponses = quizs.stream()
			.filter(quiz -> quiz.getUser().isCertificate() == auth)
			.map(this::ofQuizResponse).toList();
		return new QuizResponses(quizResponses.size(), quizResponses);
	}

	private QuizResponses.QuizResponse ofQuizResponse(Quiz quiz) {
		return QuizResponses.QuizResponse.builder()
			.id(quiz.getId())
			.image(s3Util.getQuizDefaultImage(quiz.getPath()))
			.title(quiz.getTitle())
			.introduction(quiz.getIntroduction())
			.category(quiz.getIntroduction())
			.starRating(quiz.getStar())
			.writer(quiz.getUser().getId())
			.isCertificate(quiz.getUser().isCertificate())
			.totalProblem(problemRepository.countByQuizId(quiz.getId()))
			.build();
	}

}
