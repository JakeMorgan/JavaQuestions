package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.AnswerRepository;
import com.accenture.JavaQuestions.access.QuestionRepository;
import com.accenture.JavaQuestions.dto.AnswerDTO;
import com.accenture.JavaQuestions.dto.QuestionDTO;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.exceptions.NotFoundException;
import com.accenture.JavaQuestions.mappers.AnswerMapper;
import com.accenture.JavaQuestions.mappers.QuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Boolean deleteQuestion(Question question) {
        try {
            answerRepository.deleteAll(question.getAnswersList());
            questionRepository.delete(question);
            return true;
        }catch (DataAccessException ex){
            LOG.error(ex.getMessage());
            throw new RuntimeException("Delete question fail");
        }
    }

    @Override
    public List<Question> getQuestionsList() {
        return (List<Question>) questionRepository.findAll();
    }
    @Override
    public Optional<Question> getQuestion(Long id){
        return questionRepository.findById(id);
    }

    public QuestionDTO convert(Question question){
        QuestionDTO questionDTO = QuestionMapper.INSTANCE.toDTO(question);
        List<AnswerDTO> answerDTOList = AnswerMapper.INSTANCE.toAnswerDTOList(question.getAnswersList());
        questionDTO.setAnswersList(answerDTOList);
        return questionDTO;
    }

    public List<QuestionDTO> convertList(List<Question> questionList){
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Question question:questionList){
            questionDTOList.add(convert(question));
        }
        return questionDTOList;
    }
}
