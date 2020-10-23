package com.accenture.JavaQuestions.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Answer {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionTestId")
    private QuestionTest questionTest;
    @Getter
    @Setter
    private String answerText;
    @Getter
    @Setter
    private Boolean isCorrect;

    public Answer(){

    }
    public Answer(QuestionTest questionTest, String answerText, Boolean isCorrect){
        this.questionTest = questionTest;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }
}
