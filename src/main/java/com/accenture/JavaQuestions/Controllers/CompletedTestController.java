package com.accenture.JavaQuestions.Controllers;

import com.accenture.JavaQuestions.business.CompletedTestBusinessService;
import com.accenture.JavaQuestions.dto.CompletedTestDTO;
import com.accenture.JavaQuestions.entity.CompletedTest;
import com.accenture.JavaQuestions.entity.Test;
import com.accenture.JavaQuestions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/completedtest")
public class CompletedTestController {
    @Autowired
    private CompletedTestBusinessService completedTestBusinessService;
    @GetMapping()
    public List<CompletedTestDTO> getCompletedTests(){
        return completedTestBusinessService.getCompletedTests();
    }
    @GetMapping("{id}")
    public CompletedTestDTO getCompletedTest(@PathVariable Long id){
        return completedTestBusinessService.getCompletedTest(id);
    }
    @PostMapping()
    public CompletedTest completedTestCreate(@RequestBody CompletedTest completedTest){
        return completedTestBusinessService.create(completedTest);
    }
    @PutMapping()
    public CompletedTest completedTestEdit(@RequestBody CompletedTest completedTest){
        return completedTestBusinessService.edit(completedTest);
    }
    @DeleteMapping("{id}")
    public void completedTestDelete(@PathVariable Long id){
        completedTestBusinessService.deleteCompletedTest(id);
    }
}
