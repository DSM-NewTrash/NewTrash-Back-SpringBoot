package com.dsm.newtrash.back.springboot.domain.quiz.exception.error;

import com.dsm.newtrash.back.springboot.global.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuizErrorCode implements ErrorCode {

	QUIZ_NOT_FOUND(404,"문제집을 찾을 수 없습니다.");

	private final int status;
	private final String message;

}
