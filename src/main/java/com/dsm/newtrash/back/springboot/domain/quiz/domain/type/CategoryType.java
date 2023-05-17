package com.dsm.newtrash.back.springboot.domain.quiz.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryType {
	POLLUTION("환경오염"), TRASH("분리수거"), DISASTER("환경재해"), ETC("기타");
	private final String category;
}
