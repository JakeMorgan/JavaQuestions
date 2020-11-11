package com.accenture.JavaQuestions.Controllers;

import com.accenture.JavaQuestions.business.CompletedTestBusinessService;
import com.accenture.JavaQuestions.business.TestBusinessService;
import com.accenture.JavaQuestions.dto.PageDTO;
import com.accenture.JavaQuestions.dto.TestDTO;
import com.accenture.JavaQuestions.entity.CompletedTest;
import com.accenture.JavaQuestions.entity.Question;
import com.accenture.JavaQuestions.entity.Test;
import com.accenture.JavaQuestions.entity.User;
import com.accenture.JavaQuestions.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tests")
public class TestController {
    @Autowired
    private TestBusinessService testBusinessService;
    @Autowired
    private CompletedTestBusinessService completedTestBusinessService;
    @GetMapping()
    public PageDTO getTests(
            @RequestParam(required = false, defaultValue = "", name = "filter") String filter,
            @PageableDefault(size = 5) Pageable pageable)
    {
        return testBusinessService.result(filter, pageable);
    }

    @GetMapping("{id}")
    public TestDTO getTest(@PathVariable Long id){
        return testBusinessService.convert(testBusinessService.getTest(id).orElseThrow(NotFoundException::new));
    }
    @PostMapping()
    public Test createTest(@RequestBody Test test){
        return testBusinessService.createTest(test);
    }
    @PostMapping("{id}")
    public TestDTO addQuestion(@PathVariable Long id, @RequestBody Question question){
        return testBusinessService.addQuestion(id, question);
    }
    @PostMapping("{id}/completed")
    public CompletedTest completedTest(@RequestBody CompletedTest completedTest){
        return completedTestBusinessService.create(completedTest);
    }
    @PutMapping()
    public Test editTest(@RequestBody Test test){
        return testBusinessService.editTest(test);
    }
    @DeleteMapping("{id}/deletequestion")
    public Test deleteQuestion(@PathVariable Long id, @RequestBody Question question){
        return testBusinessService.deleteQuestion(id, question);
    }
    @DeleteMapping("{id}")
    public void deleteTest(@PathVariable Long id){
        testBusinessService.deleteTest(id);
    }


}
