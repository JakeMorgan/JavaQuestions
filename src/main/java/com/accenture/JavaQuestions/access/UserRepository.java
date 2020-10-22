package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByUserNameAndPassword(String userName, String password);
}
