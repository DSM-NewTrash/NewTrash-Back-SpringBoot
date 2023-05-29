package com.dsm.newtrash.back.springboot.domain.review.presentation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsm.newtrash.back.springboot.domain.review.presentation.dto.request.StarRequest;
import com.dsm.newtrash.back.springboot.domain.review.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/quizs")
@RequiredArgsConstructor
@RestController
public class ReviewController {

	private final ReviewService reviewService;

	@PutMapping("/review/{id}")
	public void saveReview(@PathVariable("id")Long quizId, @RequestBody @Valid StarRequest request) {
		reviewService.updateReview(quizId, request);
	}

}
