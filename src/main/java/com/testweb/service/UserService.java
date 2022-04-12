package com.testweb.service;

import java.util.Optional;

import com.testweb.entity.User;
import com.testweb.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

}
