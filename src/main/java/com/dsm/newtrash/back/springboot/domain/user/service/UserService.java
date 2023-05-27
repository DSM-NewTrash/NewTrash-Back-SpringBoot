package com.dsm.newtrash.back.springboot.domain.user.service;

import org.springframework.stereotype.Service;

import com.dsm.newtrash.back.springboot.domain.user.exception.UserNotSolveQuizException;
import com.dsm.newtrash.back.springboot.domain.user.service.util.UserUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserUtil userUtil;

	public void isQuizLimitCount(int totalQuiz) {
		if(userUtil.getUser().getQuizLimitCount() < totalQuiz) {
			throw UserNotSolveQuizException.EXCEPTION;
		}
	}

}
