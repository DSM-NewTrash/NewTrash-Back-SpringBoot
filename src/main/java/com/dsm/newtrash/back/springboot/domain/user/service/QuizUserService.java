package com.dsm.newtrash.back.springboot.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.review.service.ReviewService;
import com.dsm.newtrash.back.springboot.domain.user.domain.User;
import com.dsm.newtrash.back.springboot.domain.user.exception.UserNotSolveQuizException;
import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request.UpdatePointAndExpRequest;
import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.response.UserResponse;
import com.dsm.newtrash.back.springboot.domain.user.service.util.BadgeUtil;
import com.dsm.newtrash.back.springboot.domain.user.service.util.UserUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuizUserService {

	private final UserUtil userUtil;
	private final BadgeUtil badgeUtil;
	private final ReviewService reviewService;

	private static final int[] LEVEL_MAX_EXP = {0, 1000, 3000, 8000, 15000, 28000};

	@Transactional(rollbackFor = Exception.class)
	public UserResponse updatePointAndExp(Long quizId, UpdatePointAndExpRequest request) {
		User user = userUtil.getUser();

		if(user.getQuizLimitCount() < request.getTotalProblem()) throw UserNotSolveQuizException.EXCEPTION;

		if(reviewService.isReviewEmpty(user.getId())) {
			reviewService.saveReview(quizId, user.getId());

			int point = request.getCorrectAnswer()*5;
			int exp = request.getCorrectAnswer()*10;
			user.updatePointAndExp(user.getPoint()+ point, user.getExp()+exp);

			Integer level = user.getBadge().getLevel();
			if(level != 5 && LEVEL_MAX_EXP[level+1] < user.getExp()) {
				user.updateBadge(badgeUtil.getBadge(level));
			}

			user.updateQuizLimitCount(request.getTotalProblem());

			return new UserResponse(exp, point);
		} else return new UserResponse(0, 0);
	}

}
