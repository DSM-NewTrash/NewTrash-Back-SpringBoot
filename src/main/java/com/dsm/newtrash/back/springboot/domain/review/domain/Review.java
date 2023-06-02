package com.dsm.newtrash.back.springboot.domain.review.domain;

import com.dsm.newtrash.back.springboot.global.Entity.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
	private String userId;

	private int star;


	@Builder
	public Review(Long quizId, String userId) {
		this.quizId = quizId;
		this.userId = userId;
		this.star = 0;
	}

	public void update(int star) {
		this.star = star;
	}

}
