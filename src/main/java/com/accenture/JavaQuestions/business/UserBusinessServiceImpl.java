package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.UserRepository;
import com.accenture.JavaQuestions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserBusinessServiceImpl implements UserBusinessService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> login(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public Optional<User> register(String userName, String password) {
        return userRepository.findByUserName(userName).isPresent() ? Optional.empty() : Optional.of(userRepository.save(new User(userName, password)));
    }
}
