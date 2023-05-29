package com.dsm.newtrash.back.springboot.domain.review.exception;

import com.dsm.newtrash.back.springboot.domain.review.exception.error.ReviewErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class ReviewNotFoundException extends BaseException {

	public final static ReviewNotFoundException EXCEPTION = new ReviewNotFoundException();

	public ReviewNotFoundException() {
		super(ReviewErrorCode.REVIEW_NOT_FOUND);
	}

}
