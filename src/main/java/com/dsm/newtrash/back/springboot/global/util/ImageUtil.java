package com.dsm.newtrash.back.springboot.global.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ImageUtil {

	@Value("${s3.default.image.quiz}")
	private String quizDefaultImage;

	@Value("${s3.default.image.problem}")
	private String problemDefaultImage;

	public String getQuizDefaultImage(String image) {
		return (image.isEmpty()) ? quizDefaultImage : image;
	}

	public String getProblemDefaultImage(String image) {
		return (image.isEmpty()) ? problemDefaultImage : image;
	}

}
