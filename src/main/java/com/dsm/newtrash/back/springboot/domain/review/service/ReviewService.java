package com.dsm.newtrash.back.springboot.domain.review.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.review.domain.Review;
import com.dsm.newtrash.back.springboot.domain.review.domain.repository.ReviewRepository;
import com.dsm.newtrash.back.springboot.domain.review.exception.ReviewNotFoundException;
import com.dsm.newtrash.back.springboot.domain.review.presentation.dto.request.StarRequest;
import com.dsm.newtrash.back.springboot.domain.user.service.util.UserUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

	private final ReviewRepository reviewRepository;
	private final UserUtil userUtil;

	@Transactional(readOnly = true)
	public Boolean isReviewEmpty(String userId) {
		return reviewRepository.existsByUserId(userId);
	}

	@Transactional
	public long saveReview(Long quizId, String userId) {
		reviewRepository.save(Review.builder()
				.quizId(quizId)
				.userId(userId)
			.build());
		return calculateReview(quizId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateReview(Long quizId, StarRequest request) {
		String userId = userUtil.getUserId();

		Review review = reviewRepository.findByUserIdAndQuizId(userId, quizId)
			.orElseThrow(() -> ReviewNotFoundException.EXCEPTION);
		review.update(request.getStarRating());
	}

	@Transactional(rollbackFor = Exception.class)
	private long calculateReview(Long quizId) {
		List<Review> reviews = reviewRepository.findAllByQuizId(quizId);

		long totalStar = 0;
		for(Review review : reviews) totalStar += review.getStar();

		return totalStar/reviews.size();
	}

}
