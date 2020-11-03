package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.dto.*;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TestBusinessService {
    Test createTest(Test test);
    Test editTest(Test testEdit);
    void deleteTest(Long id);
    Page<Test> getTestsList(Pageable pageable);
    Page<Test> getTestsListByFilter(String filter, Pageable pageable);
    Optional<Test> getTest(Long id);
    TestDTO convert(Test test);
    ListTestDTO convertTOListTestDTO(Test test);
    PageDTO convertListTestDTOToPageDTO(Page<Test> testList);
    PageDTO result(String filter, Pageable pageable);
    Test addQuestion(Long id, Question question);
    Test deleteQuestion(Long id, Question question);
}
