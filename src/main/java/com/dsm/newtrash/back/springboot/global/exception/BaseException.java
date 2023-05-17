package com.dsm.newtrash.back.springboot.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException {

	private final ErrorCode errorCode;

}
