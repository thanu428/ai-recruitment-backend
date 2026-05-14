package com.smarthire.backend.repository;

import com.smarthire.backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}