package com.dsm.newtrash.back.springboot.domain.user.presentation.dto.response;

import lombok.Getter;

@Getter
public class UserResponse {

	private final int exp;
	private final int point;

	public UserResponse(int exp, int point) {
		this.exp = exp;
		this.point = point;
	}



}
