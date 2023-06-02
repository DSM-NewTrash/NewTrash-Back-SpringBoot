package com.dsm.newtrash.back.springboot.global.jwt.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dsm.newtrash.back.springboot.domain.user.domain.repository.UserRepository;
import com.dsm.newtrash.back.springboot.domain.user.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public Details loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findById(username)
			.map(Details::new)
			.orElseThrow(() -> UserNotFoundException.EXCEPTION);
	}

}
