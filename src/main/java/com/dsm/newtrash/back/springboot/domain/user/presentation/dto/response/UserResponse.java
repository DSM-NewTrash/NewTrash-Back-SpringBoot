package com.dsm.newtrash.back.springboot.domain.user.presentation.dto.response;

import lombok.Getter;

@Getter
public class UserResponse {

	private final int exp;
	private final int point;
	private final int correctAnswerCount;

	public UserResponse(int exp, int point, int correctAnswerCount) {
		this.exp = exp;
		this.point = point;
		this.correctAnswerCount = correctAnswerCount;
	}



}
