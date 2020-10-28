package com.accenture.JavaQuestions.dto;

import com.accenture.JavaQuestions.entity.Answer;
import com.accenture.JavaQuestions.mappers.AnswerMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class QuestionDTO {
    private Long id;
    private String question;
    private List<AnswerDTO> answersList = new ArrayList<>();

    public QuestionDTO(Long id, String question){
        this.id = id;
        this.question = question;
    }
}
