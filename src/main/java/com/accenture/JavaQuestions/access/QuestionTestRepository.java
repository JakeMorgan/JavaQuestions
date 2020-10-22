package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.QuestionTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionTestRepository extends CrudRepository<QuestionTest, Long> {

}
