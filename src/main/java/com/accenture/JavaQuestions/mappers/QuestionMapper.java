package com.accenture.JavaQuestions.mappers;
import com.accenture.JavaQuestions.dto.QuestionDTO;
import com.accenture.JavaQuestions.entity.Question;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
    QuestionDTO toDTO(Question question);
    List<QuestionDTO> toDTOList(List<Question> questionList);
}
