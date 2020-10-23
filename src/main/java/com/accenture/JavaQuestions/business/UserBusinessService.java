package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.entity.User;

import java.util.Optional;

public interface UserBusinessService {
    Optional<User> login(String userName, String password);
    Optional<User> register(String userName, String password);
}
