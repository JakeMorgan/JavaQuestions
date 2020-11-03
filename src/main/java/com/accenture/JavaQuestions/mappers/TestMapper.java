package com.accenture.JavaQuestions.mappers;

import com.accenture.JavaQuestions.dto.ListTestDTO;
import com.accenture.JavaQuestions.dto.TestDTO;
import com.accenture.JavaQuestions.entity.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
    TestDTO toDTO(Test test);
    ListTestDTO toListTestDTO(Test test);
}
