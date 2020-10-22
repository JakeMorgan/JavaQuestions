package com.accenture.JavaQuestions.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "test")
    @JoinColumn(name = "questionTestId")
    private List<QuestionTest> questionsList;
}
