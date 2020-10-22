package com.accenture.JavaQuestions.entity;

import javax.persistence.*;

@Entity
public class CompletedTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User user;
    private int result;
}
