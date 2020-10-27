package com.accenture.JavaQuestions.Controllers;

import com.accenture.JavaQuestions.business.QuestionBusinessService;
import com.accenture.JavaQuestions.business.QuestionBusinessServiceImpl;
import com.accenture.JavaQuestions.dto.AnswerDTO;
import com.accenture.JavaQuestions.dto.QuestionDTO;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.exceptions.NotFoundException;
import com.accenture.JavaQuestions.mappers.AnswerMapper;
import com.accenture.JavaQuestions.mappers.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionBusinessServiceImpl questionBusinessService;

    @GetMapping()
    public List<QuestionDTO> questionList(){
        return questionBusinessService.convertList(questionBusinessService.getQuestionsList());
    }
    @GetMapping("{id}")
    public QuestionDTO getQuestion(@PathVariable Long id){
        return questionBusinessService.convert(questionBusinessService.getQuestion(id).orElseThrow(() -> new NotFoundException()));
    }
}
