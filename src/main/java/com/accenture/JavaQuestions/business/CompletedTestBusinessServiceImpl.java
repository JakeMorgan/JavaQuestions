package com.accenture.JavaQuestions.business;

import com.accenture.JavaQuestions.access.CompletedTestRepository;
import com.accenture.JavaQuestions.dto.CompletedTestDTO;
import com.accenture.JavaQuestions.entity.CompletedTest;
import com.accenture.JavaQuestions.entity.Test;
import com.accenture.JavaQuestions.entity.User;
import com.accenture.JavaQuestions.exceptions.NotFoundException;
import com.accenture.JavaQuestions.mappers.CompletedTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompletedTestBusinessServiceImpl implements CompletedTestBusinessService{
    @Autowired
    private CompletedTestRepository completedTestRepository;
    @Autowired
    private TestBusinessService testBusinessService;
    @Autowired
    private UserBusinessService userBusinessService;

    @Override
    public CompletedTestDTO getCompletedTest(Long id){
        return convert(completedTestRepository.findById(id).orElseThrow(NotFoundException::new));
    }
    @Override
    public List<CompletedTestDTO> getCompletedTests(){
        return convertToList((List<CompletedTest>) completedTestRepository.findAll());
    }
    @Override
    public CompletedTest create(CompletedTest completedTest) {
        Optional<Test> test = testBusinessService.getTest(completedTest.getTest().getId());
        Optional<User> user = userBusinessService.getUser(completedTest.getUser().getId());
        if(!test.isPresent()){
            throw new RuntimeException("Test doesn't exist");
        }else if(!user.isPresent()){
            throw new RuntimeException("User doesn't exist");
        }
        return completedTestRepository.save(new CompletedTest(test.get(), user.get(), completedTest.getResult()));
    }

    @Override
    public CompletedTest edit(CompletedTest completedTestEdit) {
        Optional<CompletedTest> completedTest = completedTestRepository.findById(completedTestEdit.getId());
        if(!completedTest.isPresent()){
            throw new RuntimeException("Edit failed - Completed Test does not exist");
        }
        completedTest.get().setResult(completedTestEdit.getResult());

        return completedTestRepository.save(completedTest.get());
    }

    @Override
    public void deleteCompletedTest(Long id) {
        Optional<CompletedTest> completedTest = completedTestRepository.findById(id);
        if(!completedTest.isPresent()){
            throw new RuntimeException("Edit failed - Test does not exist");
        }
        completedTestRepository.delete(completedTest.get());
    }

    private List<CompletedTestDTO> convertToList(List<CompletedTest> completedTests){
        return CompletedTestMapper.INSTANCE.toListDTO(completedTests);
    }
    public CompletedTestDTO convert(CompletedTest completedTest){
        return CompletedTestMapper.INSTANCE.toDTO(completedTest);
    }
}
