package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.entity.CompletedTest;
import com.accenture.JavaQuestions.entity.User;

public interface CompletedTestService {
    CompletedTest createCompletedTest(User user, Float result);
    CompletedTest editCompletedTest(CompletedTest completedTest, Float result);
    void deleteCompletedTest(CompletedTest completedTest);
}
