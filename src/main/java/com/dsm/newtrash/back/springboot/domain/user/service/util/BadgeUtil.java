package com.dsm.newtrash.back.springboot.domain.user.service.util;

import org.springframework.stereotype.Component;

import com.dsm.newtrash.back.springboot.domain.user.domain.Badge;
import com.dsm.newtrash.back.springboot.domain.user.domain.repository.BadgeRepository;
import com.dsm.newtrash.back.springboot.domain.user.exception.BadgeNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BadgeUtil {

	private final BadgeRepository badgeRepository;

	public Badge getBadge(Integer level) {
		return badgeRepository.findById(level).orElseThrow(() -> BadgeNotFoundException.EXCEPTION);
	}

}
