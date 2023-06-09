package com.dsm.newtrash.back.springboot.domain.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.problem.exception.ProblemNotWriteUserException;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.request.ProblemRequest;
import com.dsm.newtrash.back.springboot.domain.problem.service.QuizProblemService;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.Quiz;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.repository.QuizRepository;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.type.CategoryType;
import com.dsm.newtrash.back.springboot.domain.quiz.exception.QuizNotFoundException;
import com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.request.QuizRequest;
import com.dsm.newtrash.back.springboot.domain.user.service.util.UserUtil;
import com.dsm.newtrash.back.springboot.global.aws.S3Util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizService {

	private final QuizRepository quizRepository;
	private final UserUtil userUtil;
	private final S3Util s3Util;
	private final QuizProblemService quizProblemService;

	@Transactional(rollbackFor = Exception.class)
	public void saveQuiz(QuizRequest request) {
		Long quizId = quizRepository.save(Quiz.builder()
			.title(request.getTitle())
			.introduction(request.getIntroduction())
			.path(request.getPath())
			.category(CategoryType.valueOf(request.getCategory()))
			.user(userUtil.getUser())
			.build()
		).getId();

		for (ProblemRequest problem : request.getProblems()) {
			quizProblemService.saveProblem(quizId, problem);
		}
	}

	@Transactional
	public void deleteQuiz(Long quizId) {
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> QuizNotFoundException.EXCEPTION);

		if(!quiz.getUser().equals(userUtil.getUser())) throw ProblemNotWriteUserException.EXCEPTION;

		s3Util.delete(quiz.getPath());
		quizProblemService.deleteAllProblem(quizId);
		quizRepository.delete(quiz);
	}

}