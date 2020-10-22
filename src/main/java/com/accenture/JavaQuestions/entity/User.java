package com.accenture.JavaQuestions.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CompletedTest> completedTestList;

    public User() {
    }

    public User(Long id, String userName, String password, List<CompletedTest> completedTestList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.completedTestList = completedTestList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CompletedTest> getCompletedTestList() {
        return completedTestList;
    }

    public void setCompletedTestList(List<CompletedTest> completedTestList) {
        this.completedTestList = completedTestList;
    }
}
