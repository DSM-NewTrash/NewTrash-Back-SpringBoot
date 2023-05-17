package com.dsm.newtrash.back.springboot.domain.report.environment.domain;

import com.dsm.newtrash.back.springboot.global.Entity.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_environment_report")
@Entity
public class EnvironmentReport extends BaseTimeEntity {

	@Column(nullable = false, length = 15)
	private String title;

	@Column(nullable = false, length = 20)
	private String location;

	@Column(nullable = false, length = 300)
	private String content;

	private String path;


	@Builder
	private EnvironmentReport(String title, String location, String content, String path) {
		this.title = title;
		this.location = location;
		this.content = content;
		this.path = path;
	}

}
