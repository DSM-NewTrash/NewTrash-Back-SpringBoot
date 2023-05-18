package com.dsm.newtrash.back.springboot.domain.problem.exception.error;

import com.dsm.newtrash.back.springboot.global.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProblemErrorCode implements ErrorCode {

	PROBLEM_NOT_FOUND(404,"문제를 찾을 수 없습니다.");

	private final int status;
	private final String message;

}
