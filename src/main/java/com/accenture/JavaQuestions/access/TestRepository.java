package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends CrudRepository<Test, Long> {

}
