package com.dsm.newtrash.back.springboot.domain.user.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.dsm.newtrash.back.springboot.domain.user.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
