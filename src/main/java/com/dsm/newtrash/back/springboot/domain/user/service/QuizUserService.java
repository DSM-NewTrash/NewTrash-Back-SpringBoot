package com.dsm.newtrash.back.springboot.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsm.newtrash.back.springboot.domain.problem.domain.repository.ProblemRepository;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.Quiz;
import com.dsm.newtrash.back.springboot.domain.quiz.domain.repository.QuizRepository;
import com.dsm.newtrash.back.springboot.domain.quiz.exception.QuizNotFoundException;
import com.dsm.newtrash.back.springboot.domain.review.service.ReviewService;
import com.dsm.newtrash.back.springboot.domain.user.domain.User;
import com.dsm.newtrash.back.springboot.domain.user.presentation.dto.request.UpdatePointAndExpRequests;
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
	private final QuizRepository quizRepository;
	private final ProblemRepository problemRepository;

	private static final int[] LEVEL_MAX_EXP = {0, 1000, 3000, 8000, 15000, 28000};

	@Transactional(rollbackFor = Exception.class)
	public UserResponse updatePointAndExp(Long quizId, UpdatePointAndExpRequests updatePointAndExpRequests) {
		User user = userUtil.getUser();

		if(!reviewService.isReviewEmpty(user.getId(), quizId)) {
			Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> QuizNotFoundException.EXCEPTION);
			long star = reviewService.saveReview(quizId, user.getId());
			quiz.updateStar((int)star);

			int correctAnswerCount = 0;


			for(UpdatePointAndExpRequests.UpdatePointAndExpRequest request : updatePointAndExpRequests.getSolveQuizs()) {
				if(problemRepository.existsByIdAndCorrectAnswer(request.getId(), request.getCorrectAnswer())) correctAnswerCount++;
			}
			int point = correctAnswerCount * 5;
			int exp = correctAnswerCount * 10;
			user.updatePointAndExp(user.getPoint()+ point, user.getExp()+exp);

			Integer level = user.getBadge().getLevel();
			if(level != 5 && LEVEL_MAX_EXP[level] < user.getExp()) {
				user.updateBadge(badgeUtil.getBadge(level));
			}

			user.updateQuizLimitCount(updatePointAndExpRequests.getSolveQuizs().size());

			return new UserResponse(exp, point, correctAnswerCount);
		} else return new UserResponse(0, 0, 0);
	}

}
