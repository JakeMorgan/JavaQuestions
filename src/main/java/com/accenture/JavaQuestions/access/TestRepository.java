package com.accenture.JavaQuestions.access;

import com.accenture.JavaQuestions.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
    Page<Test> findAll(Pageable pageable);
    Page<Test> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
