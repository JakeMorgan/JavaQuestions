package com.accenture.JavaQuestions.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Answer", schema = "java_quiz")
@NoArgsConstructor
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    private Question question;
    private String answerText;
    private Boolean isCorrect;

    public Answer(Question question, String answerText, Boolean isCorrect){
        this.question = question;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }
}
