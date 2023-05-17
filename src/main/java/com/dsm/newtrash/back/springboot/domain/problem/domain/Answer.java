package com.dsm.newtrash.back.springboot.domain.problem.domain;

import com.dsm.newtrash.back.springboot.global.Entity.BaseIdEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_answer")
@Entity
public class Answer extends BaseIdEntity {

	@Column(nullable = false, length = 20)
	private String answer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "problem_id")
	private Problem problem;


	@Builder
	private Answer(String answer, Problem problem) {
		this.answer = answer;
		this.problem = problem;
	}

}
