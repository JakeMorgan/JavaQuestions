package com.accenture.JavaQuestions.mappers;

import com.accenture.JavaQuestions.dto.AnswerDTO;
import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);
    AnswerDTO toDTO(Question question);
    List<AnswerDTO> toAnswerDTOList(List<Answer> list);
}
