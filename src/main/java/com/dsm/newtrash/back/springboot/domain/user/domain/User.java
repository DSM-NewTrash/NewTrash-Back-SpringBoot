package com.dsm.newtrash.back.springboot.domain.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User {

	@Id
	private String id;

	@Column(nullable = false, length = 60)
	private String password;

	private String profile;

	@Column(nullable = false, length = 30)
	private String introduce;

	@Column(nullable = false)
	private int level;

	@Column(nullable = false)
	private int point;

	@Column(nullable = false)
	private int quizLimitCount;


	@Builder
	private User(String id, String password, String profile, String introduce, int level, int point, int quizLimitCount) {
		this.id = id;
		this.password = password;
		this.profile = profile;
		this.introduce = introduce;
		this.level = level;
		this.point = point;
		this.quizLimitCount = quizLimitCount;
	}

}
