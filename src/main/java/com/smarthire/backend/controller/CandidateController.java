package com.smarthire.backend.controller;

import com.smarthire.backend.entity.Candidate;
import com.smarthire.backend.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin("*")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public Candidate saveCandidate(
            @RequestBody Candidate candidate) {

        return candidateRepository.save(candidate);
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {

        return candidateRepository.findAll();
    }
}