package com.dsm.newtrash.back.springboot.domain.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "tbl_badge")
@Entity
public class Badge {

	@Id
	private Integer level;

	@Column(nullable = false, length = 7)
	private String name;

	@Column(nullable = false)
	private String path;

}
