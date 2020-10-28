package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.AnswerRepository;
import com.accenture.JavaQuestions.access.QuestionRepository;
import com.accenture.JavaQuestions.dto.AnswerDTO;
import com.accenture.JavaQuestions.dto.PageQuestionDTO;
import com.accenture.JavaQuestions.dto.QuestionDTO;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.exceptions.NotFoundException;
import com.accenture.JavaQuestions.mappers.AnswerMapper;
import com.accenture.JavaQuestions.mappers.QuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Converter;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class QuestionBusinessServiceImpl implements QuestionBusinessService{
    private static final Logger LOG = LoggerFactory.getLogger(QuestionBusinessServiceImpl.class);
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Override
    @Transactional
    public Question createQuestion(Question question) {
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
            //LOG.error(ex.getMessage());
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
        return (Page<Question>) questionRepository.findAll(pageable);
    }
    @Override
    public Optional<Question> getQuestion(Long id){
        return questionRepository.findById(id);
    }
    @Override
    public Page<Question> getQuestionsListByFilter(String filter, Pageable pageable){
        return (Page<Question>) questionRepository.findByQuestionContainingIgnoreCase(filter, pageable);
    }

    public QuestionDTO convert(Question question){
        QuestionDTO questionDTO = QuestionMapper.INSTANCE.toDTO(question);
        List<AnswerDTO> answerDTOList = AnswerMapper.INSTANCE.toAnswerDTOList(question.getAnswersList());
        questionDTO.setAnswersList(answerDTOList);
        return questionDTO;
    }

    public PageQuestionDTO convertList(Page<Question> questionList){
        Page<QuestionDTO> questionDTOPage = questionList.map(new Function<Question, QuestionDTO>(){
            @Override
            public QuestionDTO apply(Question question) {
                return convert(question);
            }
        });
        return new PageQuestionDTO(questionDTOPage.getContent(),
                new PageQuestionDTO.Pageable(questionDTOPage.getTotalPages(),
                        questionDTOPage.getTotalElements(), questionDTOPage.getNumber()));
    }
}
