package com.accenture.JavaQuestions.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Answer", schema = "java_quiz")
public class Answer {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    //@JsonBackReference
    private Question question;
    @Getter
    @Setter
    private String answerText;
    @Getter
    @Setter
    private Boolean isCorrect;

    public Answer(){

    }
    public Answer(Question question, String answerText, Boolean isCorrect){
        this.question = question;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }
}
