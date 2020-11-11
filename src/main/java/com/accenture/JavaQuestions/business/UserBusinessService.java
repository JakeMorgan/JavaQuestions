package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.entity.User;

import java.util.Optional;

public interface UserBusinessService {
    Optional<User> getUser(Long id);
}
