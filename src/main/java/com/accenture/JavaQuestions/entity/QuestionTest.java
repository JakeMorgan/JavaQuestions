package com.accenture.JavaQuestions.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionTestId")
    private Test test;
    private String question;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "answerId")
    private List<Answer> answersList;
}
