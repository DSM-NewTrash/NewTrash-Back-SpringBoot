package com.dsm.newtrash.back.springboot.domain.problem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.problem.domain.Answer;
import com.dsm.newtrash.back.springboot.domain.problem.domain.Problem;
import com.dsm.newtrash.back.springboot.domain.problem.domain.repository.AnswerRepository;
import com.dsm.newtrash.back.springboot.domain.problem.presentation.dto.request.AnswerRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
	public Long saveAllAnswer(Problem problem, List<AnswerRequest> answers, int correctAnswer) {
		return answerRepository.saveAll(answers.stream()
			.map(answer -> {
				return new Answer(answer.getAnswer(), problem);
			}).toList()).get(correctAnswer).getId();
	}

}
