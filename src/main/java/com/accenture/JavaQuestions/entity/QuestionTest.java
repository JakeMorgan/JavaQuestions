package com.accenture.JavaQuestions.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionTest {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionTestId")
    private Test test;
    @Getter
    @Setter
    private String question;
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "answerId")
    private List<Answer> answersList;

    public QuestionTest(){

    }
    public QuestionTest(Test test, String question){
        this.test = test;
        this.question = question;
    }
}
