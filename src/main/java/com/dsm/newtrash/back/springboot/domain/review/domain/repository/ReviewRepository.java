package com.dsm.newtrash.back.springboot.domain.review.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dsm.newtrash.back.springboot.domain.review.domain.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

	Boolean existsByUserId(String userId);
	Optional<Review> findByUserIdAndQuizId(String userId, Long quizId);
	List<Review> findAllByQuizId(Long quizId);

}
