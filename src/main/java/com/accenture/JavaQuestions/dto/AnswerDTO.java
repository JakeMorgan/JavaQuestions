package com.accenture.JavaQuestions.dto;

import com.accenture.JavaQuestions.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String answerText;
    @Getter
    @Setter
    private Boolean isCorrect;
}
