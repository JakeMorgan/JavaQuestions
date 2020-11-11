package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.UserRepository;
import com.accenture.JavaQuestions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserBusinessServiceImpl implements UserBusinessService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
