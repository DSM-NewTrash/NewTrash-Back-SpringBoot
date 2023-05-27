package com.dsm.newtrash.back.springboot.domain.user.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.dsm.newtrash.back.springboot.domain.user.domain.Badge;
import com.dsm.newtrash.back.springboot.domain.user.domain.User;

public interface BadgeRepository extends CrudRepository<Badge, Integer> {

}
