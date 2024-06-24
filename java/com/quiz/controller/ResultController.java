package com.quiz.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.quiz.model.Result;
import com.quiz.service.ResultService;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/result")
public class ResultController {
  @Autowired
  private ResultService resultService;
  @PostMapping("/")
  public Result saveResult(@RequestBody Result result){
    return resultService.saveResult(result);
  }
  @GetMapping("/")
  public List<Result> getScores() throws Exception{
    return resultService.fetchScore();
  }
   @GetMapping("/{id}")
  public Result getScoreById(@PathVariable("id") Long empId){
    try{
      return resultService.getResultsById(empId);
    }
    catch(Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/{subject}")
  public Result getScoreBySubject(@PathVariable("subject") String subject){
    return resultService.getResultBySubject(subject);
  }
}















