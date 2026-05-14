package com.smarthire.backend.controller;

import com.smarthire.backend.service.MatchingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchingService matchingService;

    @GetMapping
    public int match(@RequestParam String resumeSkills,
                     @RequestParam String jobSkills){

        return matchingService.calculateMatch(
                resumeSkills,
                jobSkills
        );
    }
}