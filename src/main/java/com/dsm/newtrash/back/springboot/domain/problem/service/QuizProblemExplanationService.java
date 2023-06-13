package com.dsm.newtrash.back.springboot.domain.problem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.problem.domain.repository.ProblemRepository;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.AnswerResponse;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.ProblemExplanationResponses;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.ProblemResponses;
import com.dsm.newtrash.back.springboot.domain.review.service.ReviewService;
import com.dsm.newtrash.back.springboot.domain.user.domain.User;
import com.dsm.newtrash.back.springboot.domain.user.exception.UserNotSolveQuizException;
import com.dsm.newtrash.back.springboot.domain.user.service.util.UserUtil;
import com.dsm.newtrash.back.springboot.global.aws.S3Util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizProblemExplanationService {

	private final ProblemRepository problemRepository;
	private final ReviewService reviewService;
	private final S3Util s3Util;
	private final UserUtil userUtil;


	@Transactional(readOnly = true)
	public ProblemExplanationResponses getQuizProblemExplanation(Long quizId) {

		List<ProblemExplanationResponses.ProblemResponse> problems = problemRepository.findAllByQuizId(quizId).stream()
			.map(problem -> {
				return ProblemExplanationResponses.ProblemResponse.builder()
					.id(problem.getId())
					.form(problem.getForm().name())
					.question(problem.getQuestion())
					.correctAnswer(problem.getCorrectAnswer())
					.image(s3Util.getProblemDefaultImage(problem.getPath()))
					.answers(problem.getAnswers().stream()
						.map(answer -> new AnswerResponse(answer.getId(), answer.getAnswer()))
						.collect(Collectors.toList()))
					.explanation(problem.getExplanation())
					.build();
			}).toList();

		return new ProblemExplanationResponses(problems);
	}

}