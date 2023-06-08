package com.dsm.newtrash.back.springboot.domain.quiz.exception;

import com.dsm.newtrash.back.springboot.domain.quiz.exception.error.QuizErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class QuizBadRequestException extends BaseException {

	public final static QuizBadRequestException EXCEPTION = new QuizBadRequestException();

	public QuizBadRequestException() {
		super(QuizErrorCode.QUIZ_BAD_REQUEST);
	}

}
