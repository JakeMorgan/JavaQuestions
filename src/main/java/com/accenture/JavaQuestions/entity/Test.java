package com.accenture.JavaQuestions.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Test {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String testName;
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "test")
    @JoinColumn(name = "questionTestId")
    private List<QuestionTest> questionsList;

    public Test(){

    }
    public Test(String testName){
        this.testName = testName;
    }
}
