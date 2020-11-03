package com.accenture.JavaQuestions.mappers;
import com.accenture.JavaQuestions.dto.QuestionDTO;
import com.accenture.JavaQuestions.entity.Question;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
    QuestionDTO toDTO(Question question);
}
