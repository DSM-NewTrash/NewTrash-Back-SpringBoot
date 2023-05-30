package com.dsm.newtrash.back.springboot.global.aws;

import java.nio.charset.StandardCharsets;

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


	public void delete(String path) {
		String objectName = path.substring(5);
		int index = objectName.indexOf('.');
		amazonS3.deleteObject(bucketName, objectName.substring(0, index));
	}

	public String getQuizDefaultImage(String image) {
		return (image.isEmpty()) ? quizDefaultImage : image;
	}

	public String getProblemDefaultImage(String image) {
		return (image.isEmpty()) ? problemDefaultImage : image;
	}

}