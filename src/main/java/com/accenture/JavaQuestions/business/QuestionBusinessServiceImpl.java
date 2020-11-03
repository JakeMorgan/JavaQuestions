package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.AnswerRepository;
import com.accenture.JavaQuestions.access.QuestionRepository;
import com.accenture.JavaQuestions.dto.*;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.entity.Test;
import com.accenture.JavaQuestions.mappers.AnswerMapper;
import com.accenture.JavaQuestions.mappers.QuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class QuestionBusinessServiceImpl implements QuestionBusinessService{
    private static final Logger LOG = LoggerFactory.getLogger(QuestionBusinessServiceImpl.class);
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public QuestionBusinessServiceImpl() {
    }

    @Override
    @Transactional
    public Question createQuestion(Question question) {
        Optional<Question> checkQuestion = questionRepository.findByQuestion(question.getQuestion());
        if(checkQuestion.isPresent()){
            throw new RuntimeException("The question already exists");
        }
        try {
            List<Answer> answerList = question.getAnswersList();
            question.setAnswersList(null);
            questionRepository.save(question);
            for(Answer answer:answerList){
                answer.setQuestion(question);
            }
            answerRepository.saveAll(answerList);
            return question;
        }catch (DataAccessException ex) {
            LOG.error(ex.getMessage());
            throw new RuntimeException("Create question fail");
        }
    }

    @Override
    @Transactional
    public Question editQuestion(Question questionEdit) {
        try {
            Optional<Question> question = questionRepository.findById(questionEdit.getId());
            if(!question.isPresent())
            {
                throw new RuntimeException("Edit question fail - Question does not exist");
            }
            questionRepository.save(questionEdit);
            List<Answer> answerList = questionEdit.getAnswersList();
            for(Answer answer:answerList){
                answer.setQuestion(questionEdit);
            }
            answerRepository.saveAll(answerList);
            return questionEdit;
        }catch (DataAccessException ex){
            LOG.error(ex.getMessage());
            throw new RuntimeException("Edit question fail");
        }
    }

    @Override
    public void deleteQuestion(Long id) {
        try {
            Optional<Question> question = questionRepository.findById(id);
            if(!question.isPresent()){
                throw new RuntimeException("Delete question fail - Question does not exist");
            }
            answerRepository.deleteAll(question.get().getAnswersList());
            questionRepository.delete(question.get());
        }catch (DataAccessException ex){
            LOG.error(ex.getMessage());
            throw new RuntimeException("Delete question fail");
        }
    }

    @Override
    public Page<Question> getQuestionsList(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }
    @Override
    public Optional<Question> getQuestion(Long id){
        return questionRepository.findById(id);
    }
    @Override
    public Page<Question> getQuestionsListByFilter(String filter, Pageable pageable){
        return questionRepository.findByQuestionContainingIgnoreCase(filter, pageable);
    }
    @Override
    public QuestionDTO convert(Question question){
        QuestionDTO questionDTO = QuestionMapper.INSTANCE.toDTO(question);
        List<AnswerDTO> answerDTOList = AnswerMapper.INSTANCE.toAnswerDTOList(question.getAnswersList());
        questionDTO.setAnswersList(answerDTOList);
        return questionDTO;
    }
    @Override
    public PageDTO convertList(Page<Question> questionList){
        Page<QuestionDTO> questionDTOPage = questionList.map(this::convert);
        return new PageDTO(questionDTOPage.getContent(),
                new PageableDTO(questionDTOPage.getTotalPages(),
                        questionDTOPage.getTotalElements(), questionDTOPage.getNumber()));
    }

    public PageDTO result(String filter, Pageable pageable){
        if(filter !=null && !filter.isEmpty()){
            return convertList(getQuestionsListByFilter(filter, pageable));
        }else{
            return convertList(getQuestionsList(pageable));
        }
    }

    public Question testSaveQuestion(Question questionEdit){
        return questionRepository.save(questionEdit);
    }
}
