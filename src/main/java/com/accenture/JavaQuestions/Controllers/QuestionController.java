package com.accenture.JavaQuestions.Controllers;

import com.accenture.JavaQuestions.business.QuestionBusinessService;
import com.accenture.JavaQuestions.business.QuestionBusinessServiceImpl;
import com.accenture.JavaQuestions.dto.AnswerDTO;
import com.accenture.JavaQuestions.dto.PageQuestionDTO;
import com.accenture.JavaQuestions.dto.QuestionDTO;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.exceptions.NotFoundException;
import com.accenture.JavaQuestions.mappers.AnswerMapper;
import com.accenture.JavaQuestions.mappers.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionBusinessServiceImpl questionBusinessService;

    @GetMapping()
    public PageQuestionDTO questionList(
            @RequestParam(required = false, defaultValue = "") String filter,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
            ){
        if(filter !=null && !filter.isEmpty()){
            return questionBusinessService.convertList(questionBusinessService.getQuestionsListByFilter(filter, pageable));
        }else{
            return questionBusinessService.convertList(questionBusinessService.getQuestionsList(pageable));
        }
    }
    @GetMapping("{id}")
    public QuestionDTO getQuestion(@PathVariable Long id){
        return questionBusinessService.convert(questionBusinessService.getQuestion(id).orElseThrow(() -> new NotFoundException()));
    }

    @PostMapping()
    public Question createQuestion(@RequestBody Question question){
        return questionBusinessService.createQuestion(question);
    }
    @PutMapping()
    public Question editQuestion(@RequestBody Question question){
        return questionBusinessService.editQuestion(question);
    }
    @DeleteMapping("{id}")
    public void deleteQuestion(@PathVariable Long id){
        questionBusinessService.deleteQuestion(id);
    }
}
