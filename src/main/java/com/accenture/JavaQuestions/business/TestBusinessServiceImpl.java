package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.AnswerRepository;
import com.accenture.JavaQuestions.access.QuestionTestRepository;
import com.accenture.JavaQuestions.access.TestRepository;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.QuestionTest;
import com.accenture.JavaQuestions.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestBusinessServiceImpl implements TestBusinessService{
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionTestRepository questionTestRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Test createTest(String testName) {
        return testRepository.save(new Test(testName));
    }

    @Override
    public QuestionTest createQuestion(Test test, String question) {
        return questionTestRepository.save(new QuestionTest(test, question));
    }

    @Override
    public Answer createAnswer(QuestionTest questionTest, String answerText, Boolean isCorrect) {
        return answerRepository.save(new Answer(questionTest, answerText, isCorrect));
    }

    @Override
    public Test editTest(Test test, String testName){
        test.setTestName(testName);
        return testRepository.save(test);
    }

    @Override
    public QuestionTest editQuestion(QuestionTest questionTest, String question){
        questionTest.setQuestion(question);
        return questionTestRepository.save(questionTest);
    }

    @Override
    public Answer editAnswer(Answer answer, String answerText, Boolean isCorrect){
        answer.setAnswerText(answerText);
        answer.setIsCorrect(isCorrect);
        return answerRepository.save(answer);
    }

    @Override
    public void deleteTest(Test test){
        testRepository.delete(test);
    }

    @Override
    public void deleteQuestion(QuestionTest questionTest){
        questionTestRepository.delete(questionTest);
    }

    @Override
    public void deleteAnswer(Answer answer){
        answerRepository.delete(answer);
    }

    @Override
    public List<Test> getTestsList() {
        return (List<Test>) testRepository.findAll();
    }

    @Override
    public List<QuestionTest> getQuestionsTestList(Test test) {
        test.getQuestionsList().size();
        return test.getQuestionsList();
    }

    @Override
    public List<Answer> getAnswerList(QuestionTest questionTest) {
        return questionTest.getAnswersList();
    }
}
