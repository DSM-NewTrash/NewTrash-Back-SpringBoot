package com.dsm.newtrash.back.springboot.domain.quiz.domain;

import com.dsm.newtrash.back.springboot.domain.quiz.domain.type.CategoryType;
import com.dsm.newtrash.back.springboot.global.Entity.BaseIdEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_quiz")
@Entity
public class Quiz extends BaseIdEntity {

	@Column(nullable = false, length = 15)
	private String title;

	@Column(nullable = false, length = 30)
	private String introduction;

	private String path;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CategoryType category;


	@Builder
	private Quiz(String title, String introduction, String path) {
		this.title = title;
		this.introduction = introduction;
		this.path = path;
	}

}
