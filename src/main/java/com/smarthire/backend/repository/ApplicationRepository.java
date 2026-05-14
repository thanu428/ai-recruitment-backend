package com.smarthire.backend.repository;

import com.smarthire.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {
}