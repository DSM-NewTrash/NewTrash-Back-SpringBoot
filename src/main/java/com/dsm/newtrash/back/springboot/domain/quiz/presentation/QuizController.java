package com.dsm.newtrash.back.springboot.domain.quiz.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.response.ProblemResponses;
import com.dsm.newtrash.back.springboot.domain.problem.service.QuizProblemService;
import com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.request.QuizRequest;
import com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.response.MyQuizResponses;
import com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.response.QuizResponses;
import com.dsm.newtrash.back.springboot.domain.quiz.service.MyQuizListService;
import com.dsm.newtrash.back.springboot.domain.quiz.service.QuizListService;
import com.dsm.newtrash.back.springboot.domain.quiz.service.QuizService;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/quizs")
@RequiredArgsConstructor
@RestController
public class QuizController {

	private final QuizService quizService;
	private final QuizProblemService quizProblemService;
	private final QuizListService quizListService;
	private final MyQuizListService myQuizListService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveQuiz(@RequestBody @Valid QuizRequest request) {
		quizService.saveQuiz(request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteQuiz(@PathVariable(value = "id") Long quizId) {
		quizService.deleteQuiz(quizId);
	}

	@GetMapping("/{id}")
	public ProblemResponses solveQuiz(@PathVariable(value = "id") Long quizId) {
		return quizProblemService.findProblemByQuizId(quizId);
	}

	@GetMapping
	public QuizResponses getQuizs(@RequestParam(value = "option") String option,
									@RequestParam(value = "category") String category,
									@RequestParam(value = "auth") boolean auth) {
		return quizListService.getQuizs(option, category, auth);
	}

	@GetMapping("/my")
	public MyQuizResponses getMyQuizs() {
		return myQuizListService.getMyQuizs();
	}

}
