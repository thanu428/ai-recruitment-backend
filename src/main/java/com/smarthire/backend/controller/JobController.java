package com.smarthire.backend.controller;

import com.smarthire.backend.entity.Job;
import com.smarthire.backend.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping
    public Job create(@RequestBody Job job){
        return jobRepository.save(job);
    }

    @GetMapping
    public List<Job> getJobs(){
        return jobRepository.findAll();
    }
}