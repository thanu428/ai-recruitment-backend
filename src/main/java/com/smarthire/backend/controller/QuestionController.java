package com.smarthire.backend.controller;

import com.smarthire.backend.entity.Question;
import com.smarthire.backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @GetMapping
    public List<Question> getQuestions() {

        List<Question> questions = questionRepository.findAll();

        Collections.shuffle(questions);

        return questions.stream().limit(10).toList();
    }
}