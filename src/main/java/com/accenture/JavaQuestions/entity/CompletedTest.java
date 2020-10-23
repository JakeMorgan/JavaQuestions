package com.accenture.JavaQuestions.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class CompletedTest {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User user;
    @Getter
    @Setter
    private float result;

    public CompletedTest(){

    }

    public CompletedTest(User user, Float result){
        this.user = user;
        this.result = result;
    }
}
