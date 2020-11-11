package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.dto.CompletedTestDTO;
import com.accenture.JavaQuestions.entity.CompletedTest;
import com.accenture.JavaQuestions.entity.Test;
import com.accenture.JavaQuestions.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CompletedTestBusinessService {
    CompletedTestDTO getCompletedTest(Long id);
    List<CompletedTestDTO> getCompletedTests();
    CompletedTest create(CompletedTest completedTest);
    CompletedTest edit(CompletedTest completedTestEdit);
    void deleteCompletedTest(Long id);
}
