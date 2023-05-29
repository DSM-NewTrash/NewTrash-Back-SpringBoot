package com.dsm.newtrash.back.springboot.domain.quiz.exception;

import com.dsm.newtrash.back.springboot.domain.quiz.exception.error.QuizErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class QuizNotFoundException extends BaseException {

	public final static QuizNotFoundException EXCEPTION = new QuizNotFoundException();

	public QuizNotFoundException() {
		super(QuizErrorCode.QUIZ_NOT_FOUND);
	}

}
