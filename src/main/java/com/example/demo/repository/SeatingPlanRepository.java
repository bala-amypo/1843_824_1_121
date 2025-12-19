package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;

public interface SeatingPlanRepository extends JpaRepository<SeatingPlan, Long> {

    // ✅ REQUIRED method (missing right now)
    Optional<SeatingPlan> findByExamSession(ExamSession examSession);
}
