package com.dsm.newtrash.back.springboot.global.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class S3Util {

	private final AmazonS3 amazonS3;

	@Value("${s3.bucket}")
	private String bucketName;

	@Value("${s3.default.image.quiz}")
	private String quizDefaultImage;

	@Value("${s3.default.image.problem}")
	private String problemDefaultImage;


	public void delete(String objectName) {
		amazonS3.deleteObject(bucketName, objectName);
	}

	public String getQuizDefaultImage(String image) {
		return (image.isEmpty()) ? quizDefaultImage : image;
	}

	public String getProblemDefaultImage(String image) {
		return (image.isEmpty()) ? problemDefaultImage : image;
	}

}