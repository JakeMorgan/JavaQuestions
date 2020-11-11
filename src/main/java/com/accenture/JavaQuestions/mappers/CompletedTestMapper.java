package com.accenture.JavaQuestions.mappers;

import com.accenture.JavaQuestions.dto.CompletedTestDTO;
import com.accenture.JavaQuestions.entity.CompletedTest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompletedTestMapper {
    CompletedTestMapper INSTANCE = Mappers.getMapper(CompletedTestMapper.class);
    CompletedTestDTO toDTO(CompletedTest completedTest);
    @Mapping(target = "completedTests.user.completedTest", ignore = true)
    List<CompletedTestDTO> toListDTO(List<CompletedTest> completedTests);
}
