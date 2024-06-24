package com.quiz.controller;

import com.quiz.model.Question;
import com.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestions() {
       
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
       

    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Question> theQuestion = questionService.getQuestionById(id);
        if (theQuestion.isPresent()){
            return ResponseEntity.ok(theQuestion.get());
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
        
    }

    @PostMapping("/create-new-question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        try {
            Question createdQuestion = questionService.createQuestion(question);
            return ResponseEntity.ok(createdQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Question> updateQuestion(
            @PathVariable Long id, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        Question updatedQuestion = questionService.updateQuestion(id, question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<String>> getAllSubjects(){
        List<String> subjects = questionService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }
    @GetMapping("/fetch-questions-for-user")
    public ResponseEntity<List<Question>> getQuestionsForUser(
            @RequestParam Integer numOfQuestions, @RequestParam String subject){
        List<Question> allQuestions = questionService.getQuestionsForUser(numOfQuestions, subject);
        List<Question> mutableQuestions = new ArrayList<>(allQuestions);
        Collections.shuffle(mutableQuestions);
        int availableQuestions = Math.min(numOfQuestions, mutableQuestions.size());
        List<Question> randomQuestions = mutableQuestions.subList(0, availableQuestions);
        return ResponseEntity.ok(randomQuestions);
    }
}







