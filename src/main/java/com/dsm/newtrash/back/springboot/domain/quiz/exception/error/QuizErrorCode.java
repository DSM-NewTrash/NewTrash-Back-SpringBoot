package com.dsm.newtrash.back.springboot.domain.quiz.exception.error;

import com.dsm.newtrash.back.springboot.global.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuizErrorCode implements ErrorCode {

	QUIZ_NOT_FOUND(404,"문제집을 찾을 수 없습니다."),
	QUIZ_BAD_REQUEST(400,"option 을 올바르게 입력해주세요.");

	private final int status;
	private final String message;

}
