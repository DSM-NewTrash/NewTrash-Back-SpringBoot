package com.dsm.newtrash.back.springboot.domain.quiz.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.dsm.newtrash.back.springboot.domain.quiz.domain.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Long> {

}
