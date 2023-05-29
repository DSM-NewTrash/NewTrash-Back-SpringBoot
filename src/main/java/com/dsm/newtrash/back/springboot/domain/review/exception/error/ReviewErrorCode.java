package com.dsm.newtrash.back.springboot.domain.review.exception.error;

import com.dsm.newtrash.back.springboot.global.exception.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorCode implements ErrorCode {

	REVIEW_NOT_FOUND(404,"별점 리뷰 내역을 찾을 수 없습니다.");

	private final int status;
	private final String message;

}
