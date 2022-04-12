package com.testweb.repo;

import com.testweb.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
