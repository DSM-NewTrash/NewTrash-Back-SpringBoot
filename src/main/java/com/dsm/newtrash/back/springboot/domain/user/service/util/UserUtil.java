package com.dsm.newtrash.back.springboot.domain.user.service.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.dsm.newtrash.back.springboot.domain.user.domain.User;
import com.dsm.newtrash.back.springboot.domain.user.domain.repository.UserRepository;
import com.dsm.newtrash.back.springboot.domain.user.exception.UserNotFoundException;
import com.dsm.newtrash.back.springboot.global.jwt.exception.TokenUnauthorizedException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserUtil {

	private final UserRepository userRepository;

	public String getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw TokenUnauthorizedException.EXCEPTION;
		}
		return authentication.getName();
	}

	public User getUser() {
		return userRepository.findById(getUserId()).orElseThrow(() -> UserNotFoundException.EXCEPTION);
	}

}
