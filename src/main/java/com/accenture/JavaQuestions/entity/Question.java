package com.accenture.JavaQuestions.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Question", schema = "java_quiz")
public class Question {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String question;
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<Answer> answersList;

    public Question(){

    }
    public Question(String question){
        this.question = question;
    }

}
