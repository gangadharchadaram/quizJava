package com.quiz.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quiz.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
	Optional<Result> findBySubject(String subject);

    Optional<Result> findById(Long id);
}
