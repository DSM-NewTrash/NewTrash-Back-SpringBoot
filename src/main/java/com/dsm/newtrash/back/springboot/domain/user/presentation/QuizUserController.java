package com.dsm.newtrash.back.springboot.domain.user.presentation;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request.UpdatePointAndExpRequests;
import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.response.UserResponse;
import com.dsm.newtrash.back.springboot.domain.user.service.QuizUserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/quizs")
@RequiredArgsConstructor
@RestController
public class QuizUserController {

	private final QuizUserService quizUserService;

	@PutMapping("/adjustment/{id}")
	public UserResponse updatePointAndExp(@PathVariable("id")Long quizId, @RequestBody @Valid UpdatePointAndExpRequests request) {
		return quizUserService.updatePointAndExp(quizId, request);
	}


}
