package com.accenture.JavaQuestions.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class TestDTO {
    private Long id;
    private String name;
    private List<QuestionDTO> questionList;

    public TestDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
