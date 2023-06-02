package com.dsm.newtrash.back.springboot.domain.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

	@Column(nullable = false, length = 12)
	private String nickname;

	@Column(nullable = false, length = 60)
	private String password;

	private String profile;

	@Column(nullable = false, length = 30)
	private String introduce;

	@Column(nullable = false)
	private int point;

	@Column(nullable = false)
	private int exp;

	@Column(nullable = false, columnDefinition = "TINYINT")
	private boolean isCertificate;

	private String certificate;

	@Column(nullable = false)
	private int quizLimitCount;

	@OneToOne
	@JoinColumn(name = "badge_id")
	private Badge badge;


	@Builder
	private User(String id, String nickname, String password, String profile, String introduce,
					int point, int exp, boolean isCertificate, String certificate, int quizLimitCount, Badge badge) {
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.profile = profile;
		this.introduce = introduce;
		this.point = point;
		this.exp = exp;
		this.isCertificate = isCertificate;
		this.certificate = certificate;
		this.quizLimitCount = quizLimitCount;
		this.badge = badge;
	}

	public void updatePointAndExp(int point, int exp) {
		this.point = point;
		this.exp = exp;
	}

	public void updateBadge(Badge badge) {
		this.badge = badge;
	}

	public void updateQuizLimitCount(int totalProblem) {
		this.quizLimitCount -= totalProblem;
	}

}
