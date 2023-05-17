package com.dsm.newtrash.back.springboot.global.jwt.exception;

import com.dsm.newtrash.back.springboot.global.exception.BaseException;
import com.dsm.newtrash.back.springboot.global.jwt.exception.error.TokenErrorCode;

public class TokenUnauthorizedException extends BaseException {

	public final static TokenUnauthorizedException EXCEPTION = new TokenUnauthorizedException();

	public TokenUnauthorizedException() {
		super(TokenErrorCode.TOKEN_UNAUTHORIZED);
	}

}
