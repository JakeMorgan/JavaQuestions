package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {

}
