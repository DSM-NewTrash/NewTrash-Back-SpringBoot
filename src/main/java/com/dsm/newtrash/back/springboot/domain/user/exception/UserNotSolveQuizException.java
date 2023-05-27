package com.dsm.newtrash.back.springboot.domain.user.exception;

import com.dsm.newtrash.back.springboot.domain.user.exception.error.UserErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class UserNotSolveQuizException extends BaseException {

	public final static UserNotSolveQuizException EXCEPTION = new UserNotSolveQuizException();

	public UserNotSolveQuizException() {
		super(UserErrorCode.USER_NOT_SOLVE_QUIZ);
	}

}
