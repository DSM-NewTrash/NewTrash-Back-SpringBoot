package com.dsm.newtrash.back.springboot.domain.problem.domain;

import java.util.ArrayList;
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

	private Long correctAnswer;

	@Column(nullable = false, length = 50)
	private String explanation;

	private String path;

	private Long quizId;

	@OneToMany(mappedBy = "problem", cascade = CascadeType.REMOVE, orphanRemoval=true)
	private List<Answer> answers = new ArrayList<Answer>();


	@Builder
	private Problem(Form form, String question, Long correctAnswer, String explanation, String path, Long quizId) {
		this.form = form;
		this.question = question;
		this.explanation = explanation;
		this.path = path;
		this.quizId = quizId;
	}

	public void updateCorrectAnswer(Long correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
