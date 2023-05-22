package com.dsm.newtrash.back.springboot.domain.quiz.review.domain;

import com.dsm.newtrash.back.springboot.global.Entity.BaseIdEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_review")
@Entity
public class Review extends BaseIdEntity {

	@Column(nullable = false)
	private Long quizId;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	private int star;


	@Builder
	public Review(Long quizId, Long userId, int star) {
		this.quizId = quizId;
		this.userId = userId;
		this.star = star;
	}

}
