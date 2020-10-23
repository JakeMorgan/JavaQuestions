package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.CompletedTestRepository;
import com.accenture.JavaQuestions.entity.CompletedTest;
import com.accenture.JavaQuestions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class CompletedTestServiceImpl implements CompletedTestService{
    @Autowired
    private CompletedTestRepository completedTestRepository;
    @Override
    public CompletedTest createCompletedTest(User user, Float result) {
        return completedTestRepository.save(new CompletedTest(user, result));
    }

    @Override
    public CompletedTest editCompletedTest(CompletedTest completedTest, Float result) {
        completedTest.setResult(result);
        return completedTestRepository.save(completedTest);
    }

    @Override
    public void deleteCompletedTest(CompletedTest completedTest) {
        completedTestRepository.delete(completedTest);
    }
}
