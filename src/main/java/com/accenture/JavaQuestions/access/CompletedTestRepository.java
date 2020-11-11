package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.CompletedTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedTestRepository extends CrudRepository<CompletedTest, Long> {

}
