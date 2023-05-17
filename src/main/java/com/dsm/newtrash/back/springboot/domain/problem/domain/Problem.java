package com.dsm.newtrash.back.springboot.domain.problem.domain;

import java.util.List;

import com.dsm.newtrash.back.springboot.domain.problem.domain.type.Form;
import com.dsm.newtrash.back.springboot.global.Entity.BaseIdEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_problem")
@Entity
public class Problem extends BaseIdEntity {

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Form form;

	@Column(nullable = false, length = 30)
	private String question;

	private int correctAnswer;

	@Column(nullable = false, length = 50)
	private String explanation;

	private String path;

	private Long quiz_id;

	@OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Answer> answers;


	@Builder
	private Problem(Form form, String question, int correctAnswer, String explanation, String path, Long quiz_id) {
		this.form = form;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.explanation = explanation;
		this.path = path;
		this.quiz_id = quiz_id;
	}

}