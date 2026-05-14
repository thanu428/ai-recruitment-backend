package com.smarthire.backend.service;

import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

    public String extractSkills(String text) {

        String resumeSkills = """
                Java
                Spring Boot
                React
                """;

        String jobSkills = """
                Java
                Spring Boot
                React
                Docker
                """;

        int matched = 3;
        int total = 4;

        int score = (matched * 100) / total;

        return """
                Resume Skills:
                Java
                Spring Boot
                React

                Job Skills:
                Java
                Spring Boot
                React
                Docker

                Match Score:
                """ + score + "%";
    }
}