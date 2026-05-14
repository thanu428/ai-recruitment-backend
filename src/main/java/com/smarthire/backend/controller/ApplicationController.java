package com.smarthire.backend.controller;

import com.smarthire.backend.entity.Application;
import com.smarthire.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping
    public Application apply(@RequestBody Application application){

        return applicationRepository.save(application);
    }
}