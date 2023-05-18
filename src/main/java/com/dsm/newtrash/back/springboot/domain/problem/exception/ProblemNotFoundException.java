package com.dsm.newtrash.back.springboot.domain.problem.exception;

import com.dsm.newtrash.back.springboot.domain.problem.exception.error.ProblemErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class ProblemNotFoundException extends BaseException {

	public final static ProblemNotFoundException EXCEPTION = new ProblemNotFoundException();

	public ProblemNotFoundException() {
		super(ProblemErrorCode.PROBLEM_NOT_FOUND);
	}

}
