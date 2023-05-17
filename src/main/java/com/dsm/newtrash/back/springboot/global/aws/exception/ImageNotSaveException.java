package com.dsm.newtrash.back.springboot.global.aws.exception;

import com.dsm.newtrash.back.springboot.global.aws.exception.error.ImageErrorCode;
import com.dsm.newtrash.back.springboot.global.exception.BaseException;

public class ImageNotSaveException extends BaseException {
	public static final ImageNotSaveException EXCEPTION = new ImageNotSaveException();
	private ImageNotSaveException() {
		super(ImageErrorCode.IMAGE_NOT_SAVE);
	}
}