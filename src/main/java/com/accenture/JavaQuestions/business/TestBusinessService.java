package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.QuestionTest;
import com.accenture.JavaQuestions.entity.Test;

import java.util.List;

public interface TestBusinessService {
    Test createTest(String testName);
    QuestionTest createQuestion(Test test, String question);
    Answer createAnswer(QuestionTest questionTest, String answerText, Boolean isCorrect);
    Test editTest(Test test, String testName);
    QuestionTest editQuestion(QuestionTest questionTest, String question);
    Answer editAnswer(Answer answer, String answerText, Boolean isCorrect);
    void deleteTest(Test test);
    void deleteQuestion(QuestionTest questionTest);
    void deleteAnswer(Answer answer);
    List<Test> getTestsList();
    List<QuestionTest> getQuestionsTestList(Test test);
    List<Answer> getAnswerList(QuestionTest questionTest);
}
