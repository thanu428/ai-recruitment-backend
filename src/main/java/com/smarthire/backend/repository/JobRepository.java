package com.smarthire.backend.repository;

import com.smarthire.backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}