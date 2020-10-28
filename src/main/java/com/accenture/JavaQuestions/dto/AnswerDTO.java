package com.accenture.JavaQuestions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnswerDTO {
    private Long id;
    private String answerText;
    private Boolean isCorrect;
}
