package com.pgssoftware.service;

import com.pgssoftware.model.User;
import io.vavr.control.Try;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(long userId) {

        try {
            return userRepository.findById(userId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Try<User> getUserVavr(long userId) {

        return Try.of(() -> userRepository.findById(userId));
    }
}
