package com.accenture.JavaQuestions.dto;

import com.accenture.JavaQuestions.entity.Test;
import com.accenture.JavaQuestions.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompletedTestDTO {
    private Long id;
    private Test test;
    private User user;
    private String result;
}
