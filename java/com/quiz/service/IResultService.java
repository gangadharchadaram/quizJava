package com.quiz.service;

import java.util.*;

import com.quiz.model.Result;

public interface IResultService {

    Result saveResult(Result result);
    
    List<Result>fetchScore();

    Result getResultsById(Long EmpId);

    Result getResultBySubject(String subjcet);
}
