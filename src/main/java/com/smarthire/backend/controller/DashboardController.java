package com.smarthire.backend.controller;

import com.smarthire.backend.repository.ApplicationRepository;
import com.smarthire.backend.repository.JobRepository;
import com.smarthire.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    public Map<String, Long> getDashboardData(){

        Map<String, Long> data = new HashMap<>();

        data.put("totalUsers", userRepository.count());

        data.put("totalJobs", jobRepository.count());

        data.put("totalApplications",
                applicationRepository.count());

        return data;
    }
}