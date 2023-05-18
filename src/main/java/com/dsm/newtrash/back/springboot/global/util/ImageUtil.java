package com.dsm.newtrash.back.springboot.global.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ImageUtil {

	@Value("${s3.default.image}")
	private String defaultImage;

	public String getImage(String image) {
		return (image.isEmpty()) ? defaultImage : image;
	}

}
