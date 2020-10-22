package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
