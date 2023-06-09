package com.dsm.newtrash.back.springboot.domain.quiz.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dsm.newtrash.back.springboot.domain.quiz.domain.Quiz;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.type.CategoryType;
import com.dsm.newtrash.back.springboot.domain.user.domain.User;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
	List<Quiz> findAllByOrderByIdDesc();
	List<Quiz> findAllByOrderByStarDesc();

	List<Quiz> findAllByCategoryOrderByIdDesc(CategoryType category);
	List<Quiz> findAllByCategoryOrderByStarDesc(CategoryType category);

	List<Quiz> findAllByUserOrderByIdDesc(User user);
}
