package com.quiz.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.model.Result;
import com.quiz.repository.ResultRepository;
@Service
public class ResultService implements IResultService{
  @Autowired
  private ResultRepository resultRepository;
  @Override
  public Result saveResult(Result result) {
    return resultRepository.save(result);
  }
  @Override
  public List<Result> fetchScore() {
    List<Result>allResults=resultRepository.findAll();
    return allResults;
  }
  @Override
  public Result getResultsById(Long Id) {
    Optional<Result>  result =resultRepository.findById(Id);
    if(result.isPresent()){
      return result.get();
    }
    return null;
  }
  @Override
  public Result getResultBySubject(String subject) {
    Optional<Result>  result =resultRepository.findBySubject(subject);
    if(result.isPresent()){
      return result.get();
    }
    return null;
  }
}















