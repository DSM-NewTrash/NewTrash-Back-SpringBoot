package com.dsm.newtrash.back.springboot.domain.user.exception;

import com.dsm.newtrash.back.springboot.domain.user.exception.error.UserErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class BadgeNotFoundException extends BaseException {

	public final static BadgeNotFoundException EXCEPTION = new BadgeNotFoundException();

	public BadgeNotFoundException() {
		super(UserErrorCode.BADGE_NOT_FOUND);
	}

}
