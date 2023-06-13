package com.dsm.newtrash.back.springboot.domain.problem.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dsm.newtrash.back.springboot.domain.problem.domain.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Long> {
	List<Problem> findAllByQuizId(Long quizId);
	int countByQuizId(Long quizId);
	boolean existsByIdAndCorrectAnswer(Long id, Long correctAnswer);

}
