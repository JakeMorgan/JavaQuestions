package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Page<Question> findAll(Pageable pageable);
    Page<Question> findByQuestionContainingIgnoreCase(String question, Pageable pageable);
    Optional<Question> findByQuestion(String question);
}
