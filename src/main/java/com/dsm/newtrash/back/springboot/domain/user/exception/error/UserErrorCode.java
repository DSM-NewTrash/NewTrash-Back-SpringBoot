package com.dsm.newtrash.back.springboot.domain.user.exception.error;

import com.dsm.newtrash.back.springboot.global.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

	USER_NOT_FOUND(404,"사용자를 찾을 수 없습니다."),
	BADGE_NOT_FOUND(404,"뱃지를 찾을 수 없습니다."),
	USER_NOT_SOLVE_QUIZ(409, "문제를 풀 수 없습니다. 풀 수 있는 문제의 개수를 확인해주세요.");

	private final int status;
	private final String message;

}
