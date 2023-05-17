package com.dsm.newtrash.back.springboot.domain.problem.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.dsm.newtrash.back.springboot.domain.problem.domain.Problem;

public interface ProblemRepository extends CrudRepository<Long, Problem> {

}
