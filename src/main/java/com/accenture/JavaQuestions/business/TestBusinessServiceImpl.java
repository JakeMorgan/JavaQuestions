package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.TestRepository;
import com.accenture.JavaQuestions.dto.*;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.entity.Test;
import com.accenture.JavaQuestions.mappers.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TestBusinessServiceImpl implements TestBusinessService{
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionBusinessService questionBusinessService;
    @Override
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test editTest(Test testEdit) {
        Optional<Test> test = testRepository.findById(testEdit.getId());
        if(!test.isPresent()){
            throw new RuntimeException("Edit test fail - Test does not exist");
        }
        test.get().setName(testEdit.getName());
        return testRepository.save(test.get());
    }

    @Override
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public Page<Test> getTestsList(Pageable pageable) {
        return testRepository.findAll(pageable);
    }

    @Override
    public Page<Test> getTestsListByFilter(String filter, Pageable pageable) {
        return testRepository.findByNameContainingIgnoreCase(filter, pageable);
    }
    @Override
    public Optional<Test> getTest(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public TestDTO convert(Test test) {
        return TestMapper.INSTANCE.toDTO(test);
    }

    //////////////////////////////////////LIST DTO IGNORE QUESTIONLIST////////////////////////
    public OnlyTestDTO convertTOListTestDTO(Test test) {
        return TestMapper.INSTANCE.toListTestDTO(test);
    }

    public PageDTO convertListTestDTOToPageDTO(Page<Test> testList){
        Page<OnlyTestDTO> listTestDTOPage = testList.map(this::convertTOListTestDTO);
        return new PageDTO(listTestDTOPage.getContent(),
                new PageableDTO(listTestDTOPage.getTotalPages(),
                        listTestDTOPage.getTotalElements(), listTestDTOPage.getNumber()));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public PageDTO result(String filter, Pageable pageable){
        if(filter !=null && !filter.isEmpty()){
            return convertListTestDTOToPageDTO(getTestsListByFilter(filter, pageable));
        }else{
            return convertListTestDTOToPageDTO(getTestsList(pageable));
        }
    }

    public TestDTO addQuestion(Long id, Question question){
        Optional<Test> test = testRepository.findById(id);
        if(!test.isPresent()){
            throw new RuntimeException("Add Question fail - Test does not exist");
        }
        ////////////////////////////TEST///////////////////////
        test.get().load();
        List<Question> questionList = test.get().getQuestionList();
        Set<Question> questions = new HashSet<>();
        for(Question question1: questionList){
            questions.add(question1);
        }
        ///////////////////////////Question/////////////////////
        Optional<Question> questionEdit = questionBusinessService.getQuestion(question.getId());
        if(!test.isPresent()){
            throw new RuntimeException("Add Question fail - Question does not exist");
        }
        List<Test> testList;
        if(question.getTestList() != null) {
            testList = questionEdit.get().getTestList();
        }else{
            testList = new ArrayList<>();
        }
        testList.add(test.get());
        questionEdit.get().setTestList(testList);
        questionBusinessService.testSaveQuestion(questionEdit.get());
        questions.add(questionEdit.get());
        test.get().setQuestionList(new ArrayList<>(questions));
        testRepository.save(test.get());
        return convert(test.get());
    }

    public Test deleteQuestion(Long id, Question question){
        Optional<Test> test = testRepository.findById(id);
        Optional<Question> questionEdit = questionBusinessService.getQuestion(question.getId());

        if(!test.isPresent()){
            throw new RuntimeException("Delete Question fail - Test does not exist");
        }
        if(test.get().getQuestionList() == null){
            throw new RuntimeException("Delete Question fail - the test has no questions");
        }
        Set<Test> questions = new HashSet<>(questionEdit.get().getTestList());
        questions.remove(test.get());
        questionEdit.get().setTestList(new ArrayList<>(questions));
        questionBusinessService.testSaveQuestion(questionEdit.get());

        Set<Question> testQuestions = new HashSet<>(test.get().getQuestionList());
        testQuestions.remove(questionEdit.get());
        test.get().setQuestionList(new ArrayList<>(testQuestions));

        return testRepository.save(test.get());
    }
}
