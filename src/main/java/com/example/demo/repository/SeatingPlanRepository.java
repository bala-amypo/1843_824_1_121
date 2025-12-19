package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.SeatingPlan;

public interface SeatingPlanRepository extends JpaRepository<SeatingPlan, Long> {

    List<SeatingPlan> findByExamSession_Id(Long sessionId);
}
