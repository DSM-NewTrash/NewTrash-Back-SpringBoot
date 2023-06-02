package com.dsm.newtrash.back.springboot.domain.report.quiz.domain;

import com.dsm.newtrash.back.springboot.domain.problem.domain.Problem;
import com.dsm.newtrash.back.springboot.global.Entity.BaseTimeEntity;

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
@Table(name = "tbl_quiz_report")
@Entity
public class QuizReport extends BaseTimeEntity {

	@Column(nullable = false, length = 15)
	private String title;

	@Column(nullable = false)
	private int number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "problem_id")
	private Problem problem;


	@Builder
	private QuizReport(String title, int number, Problem problem) {
		this.title = title;
		this.number = number;
		this.problem = problem;
	}

}
