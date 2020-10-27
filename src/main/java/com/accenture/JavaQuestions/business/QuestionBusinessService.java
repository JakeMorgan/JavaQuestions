package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionBusinessService {
    Question createQuestion(Question question);
    Question editQuestion(Question questionEdit);
    Boolean deleteQuestion(Question question);
    List<Question> getQuestionsList();
    Optional<Question> getQuestion(Long id);
}
