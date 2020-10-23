package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.QuestionTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionTestRepository extends CrudRepository<QuestionTest, Long> {

}
