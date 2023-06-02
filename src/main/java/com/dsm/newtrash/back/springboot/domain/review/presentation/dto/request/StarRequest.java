package com.dsm.newtrash.back.springboot.domain.review.presentation.dto.request;

import javax.validation.constraints.Max;
import lombok.Getter;

@Getter
public class StarRequest {

	@Max(value = 5)
	private int starRating;

}
