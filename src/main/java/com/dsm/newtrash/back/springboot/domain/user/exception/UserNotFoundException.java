package com.dsm.newtrash.back.springboot.domain.user.exception;

import com.dsm.newtrash.back.springboot.domain.user.exception.error.UserErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class UserNotFoundException extends BaseException {

	public final static UserNotFoundException EXCEPTION = new UserNotFoundException();

	public UserNotFoundException() {
		super(UserErrorCode.USER_NOT_FOUND);
	}

}
