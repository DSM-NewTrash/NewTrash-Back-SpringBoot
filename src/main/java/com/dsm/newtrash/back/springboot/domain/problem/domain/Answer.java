package com.dsm.newtrash.back.springboot.domain.problem.domain;

import com.dsm.newtrash.back.springboot.global.Entity.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	public Answer(String answer, Problem problem) {
		this.answer = answer;
		this.problem = problem;
	}

}
