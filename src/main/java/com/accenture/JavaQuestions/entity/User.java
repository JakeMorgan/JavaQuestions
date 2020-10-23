package com.accenture.JavaQuestions.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class User{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CompletedTest> completedTestList;

    public User() {
    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
