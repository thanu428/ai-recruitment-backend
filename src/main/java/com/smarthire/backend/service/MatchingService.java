package com.smarthire.backend.service;

import org.springframework.stereotype.Service;

@Service
public class MatchingService {

    public int calculateMatch(String resumeSkills,
                              String jobSkills){

        String[] resume =
                resumeSkills.toLowerCase().split(",");

        String[] job =
                jobSkills.toLowerCase().split(",");

        int matched = 0;

        for(String r : resume){

            for(String j : job){

                if(r.trim().equals(j.trim())){

                    matched++;
                }
            }
        }

        return (matched * 100) / job.length;
    }
}