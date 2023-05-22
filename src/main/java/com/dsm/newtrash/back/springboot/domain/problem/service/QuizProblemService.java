package com.dsm.newtrash.back.springboot.domain.problem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.problem.domain.Problem;
import com.dsm.newtrash.back.springboot.domain.problem.domain.repository.ProblemRepository;
import com.dsm.newtrash.back.springboot.domain.problem.domain.type.Form;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.request.ProblemRequest;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.AnswerResponse;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.ProblemResponses;
import com.dsm.newtrash.back.springboot.global.util.ImageUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizProblemService {

	private final ProblemRepository problemRepository;

	private final AnswerService answerService;
	private final ImageUtil imageUtil;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
	public void saveProblem(Long quizId, ProblemRequest request) {
		Problem problem = problemRepository.save(Problem.builder()
					.form(Form.valueOf(request.getForm()))
					.question(request.getQuestion())
					.correctAnswer(request.getCorrectAnswer())
					.explanation(request.getExplanation())
					.path(request.getPath())
					.quizId(quizId)
					.build()
		);

		if(Form.valueOf(request.getForm()).equals(Form.MULTIPLE_CHOICE_QUIZ)) {
			answerService.saveAllAnswer(problem, request.getAnswers());
		}
	}

	public void deleteAllProblem(Long quizId) {
		List<Problem> problems = problemRepository.findAllByQuizId(quizId);
		problemRepository.deleteAll(problems);
	}

	public ProblemResponses finadProblemByQuizId(Long quizId) {
		List<ProblemResponses.ProblemResponse> problems = problemRepository.findAllByQuizId(quizId).stream()
			.map(problem -> {
				return ProblemResponses.ProblemResponse.builder()
					.id(problem.getId())
					.form(problem.getForm().name())
					.question(problem.getQuestion())
					.correctAnswer(problem.getCorrectAnswer())
					.image(imageUtil.getImage(problem.getPath()))
					.answers(problem.getAnswers().stream()
						.map(answer -> new AnswerResponse(answer.getAnswer()))
						.collect(Collectors.toList()))
					.build();
			}).toList();

		return new ProblemResponses(problems.size(), problems);
	}

}
