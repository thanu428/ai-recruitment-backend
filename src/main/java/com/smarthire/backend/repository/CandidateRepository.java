package com.smarthire.backend.repository;

import com.smarthire.backend.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository
        extends JpaRepository<Candidate, Long> {
}