package com.dsm.newtrash.back.springboot.global.exception.handler;

import java.io.IOException;



import org.springframework.web.filter.OncePerRequestFilter;

import com.dsm.newtrash.back.springboot.global.exception.BaseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewTrashExceptionFilter extends OncePerRequestFilter {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
		ServletException, IOException {

		try {
			filterChain.doFilter(request, response);
		} catch (BaseException e) {
			response.setStatus(e.getErrorCode().getStatus());

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getStatus(), e.getErrorCode().getMessage());
			response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
		}
	}

}
