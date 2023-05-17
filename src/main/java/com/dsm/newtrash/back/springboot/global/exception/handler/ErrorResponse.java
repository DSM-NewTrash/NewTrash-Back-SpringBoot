package com.dsm.newtrash.back.springboot.global.exception.handler;

import lombok.Getter;

@Getter
public class ErrorResponse {

	private final int status;
	private final String message;

	protected ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

}
