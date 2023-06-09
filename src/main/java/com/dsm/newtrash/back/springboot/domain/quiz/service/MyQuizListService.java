package com.dsm.newtrash.back.springboot.domain.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsm.newtrash.back.springboot.domain.quiz.domain.Quiz;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.repository.QuizRepository;
import com.dsm.newtrash.back.springboot.domain.quiz.presentation.dto.response.MyQuizResponses;
import com.dsm.newtrash.back.springboot.domain.user.service.util.UserUtil;
import com.dsm.newtrash.back.springboot.global.aws.S3Util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyQuizListService {

	private final QuizRepository quizRepository;
	private final UserUtil userUtil;
	private final S3Util s3Util;

	public MyQuizResponses getMyQuizs() {
		List<Quiz> quizs = quizRepository.findAllByUserOrderByIdDesc(userUtil.getUser());

		return new MyQuizResponses(quizs.size(),
			quizs.stream().map(quiz -> {
				return MyQuizResponses.QuizResponse.builder()
					.id(quiz.getId())
					.image(s3Util.getMyQuizDefaultImage(quiz.getPath()))
					.title(quiz.getTitle())
					.introduction(quiz.getIntroduction())
					.category(quiz.getCategory().getCategory())
					.build();
			}).toList());

	}

}
