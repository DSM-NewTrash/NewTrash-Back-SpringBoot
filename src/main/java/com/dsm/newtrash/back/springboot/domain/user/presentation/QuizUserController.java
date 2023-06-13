package com.dsm.newtrash.back.springboot.domain.user.presentation;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request.UpdatePointAndExpRequest;
import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.response.UserResponse;
import com.dsm.newtrash.back.springboot.domain.user.service.QuizUserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/quizs")
@RequiredArgsConstructor
@RestController
@Validated
public class QuizUserController {

	private final QuizUserService quizUserService;

	@PutMapping("/adjustment/{id}")
	public UserResponse updatePointAndExp(@PathVariable("id")Long quizId, @RequestBody @Valid @NotNull List<UpdatePointAndExpRequest> request) {
		return quizUserService.updatePointAndExp(quizId, request);
	}


}
