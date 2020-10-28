package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionBusinessService {
    Question createQuestion(Question question);
    Question editQuestion(Question questionEdit);
    void deleteQuestion(Long id);
    Page<Question> getQuestionsList(Pageable pageable);
    Page<Question> getQuestionsListByFilter(String filter, Pageable pageable);
    Optional<Question> getQuestion(Long id);
}
