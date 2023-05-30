package com.dsm.newtrash.back.springboot.domain.problem.exception;

import com.dsm.newtrash.back.springboot.domain.problem.exception.error.ProblemErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class ProblemNotWriteUserException extends BaseException {

	public final static ProblemNotWriteUserException EXCEPTION = new ProblemNotWriteUserException();

	public ProblemNotWriteUserException() {
		super(ProblemErrorCode.PROBLEM_NOT_WRITE_USER);
	}

}
