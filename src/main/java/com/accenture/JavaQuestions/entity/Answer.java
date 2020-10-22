package com.accenture.JavaQuestions.entity;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionTestId")
    private QuestionTest questionTest;
    private String questionText;
    private Boolean isCorrect;
}
