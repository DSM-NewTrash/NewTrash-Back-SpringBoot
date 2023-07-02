package com.dsm.newtrash.back.springboot.domain.problem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.problem.domain.Problem;
import com.dsm.newtrash.back.springboot.domain.problem.domain.repository.AnswerRepository;
import com.dsm.newtrash.back.springboot.domain.problem.domain.repository.ProblemRepository;
import com.dsm.newtrash.back.springboot.domain.problem.exception.ProblemNotFoundException;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.AnswerResponse;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.ProblemExplanationResponses;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.ProblemResponses;
import com.dsm.newtrash.back.springboot.domain.review.service.ReviewService;
import com.dsm.newtrash.back.springboot.domain.user.domain.User;
import com.dsm.newtrash.back.springboot.domain.user.exception.UserNotSolveQuizException;
import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request.SolveQuizRequests;
import com.dsm.newtrash.back.springboot.domain.user.service.util.UserUtil;
import com.dsm.newtrash.back.springboot.global.aws.S3Util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizProblemExplanationService {

	private final ProblemRepository problemRepository;
	private final S3Util s3Util;

	@Transactional(readOnly = true)
	public ProblemExplanationResponses getQuizProblemExplanation(SolveQuizRequests requests) {
		List<ProblemExplanationResponses.ProblemResponse> problemResponses = new ArrayList<>();

		for(SolveQuizRequests.SolveQuizRequest request : requests.getSolveQuizs()) {
			Problem problem = problemRepository.findById(request.getId()).orElseThrow(() -> ProblemNotFoundException.EXCEPTION);

			problemResponses.add(ProblemExplanationResponses.ProblemResponse.builder()
				.id(problem.getId())
				.form(problem.getForm().name())
				.question(problem.getQuestion())
				.correctAnswer(problem.getCorrectAnswer())
				.userAnswer(request.getCorrectAnswer())
				.image(s3Util.getProblemDefaultImage(problem.getPath()))
				.answers(problem.getAnswers().stream()
					.map(answer -> new AnswerResponse(answer.getId(), answer.getAnswer())).toList())
				.explanation(problem.getExplanation())
				.build()
			);
		}

		return new ProblemExplanationResponses(problemResponses);
	}

}