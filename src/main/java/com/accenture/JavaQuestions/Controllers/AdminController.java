package com.accenture.JavaQuestions.Controllers;

import com.accenture.JavaQuestions.business.QuestionBusinessServiceImpl;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private QuestionBusinessServiceImpl questionBusinessService;

    @PostMapping("/create")
    public Question createQuestion(@RequestBody Question question){
        return questionBusinessService.createQuestion(question);
    }
    @PutMapping("/edit")
    public Question editQuestion(@RequestBody Question question){
        return questionBusinessService.editQuestion(question);
    }
    @DeleteMapping("/delete")
    public Boolean deleteQuestion(@RequestBody Question question){
        return  questionBusinessService.deleteQuestion(question);
    }
}
