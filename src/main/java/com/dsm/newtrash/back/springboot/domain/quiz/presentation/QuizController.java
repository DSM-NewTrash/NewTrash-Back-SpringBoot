package com.dsm.newtrash.back.springboot.domain.quiz.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.request.QuizRequest;
import com.dsm.newtrash.back.springboot.domain.quiz.service.QuizService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/quizs")
@RequiredArgsConstructor
@RestController
public class QuizController {

	private QuizService quizService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveQuiz(QuizRequest request) {
		quizService.saveQuiz(request);
	}

}
