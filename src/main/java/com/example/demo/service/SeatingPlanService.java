package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SeatingPlan;

public interface SeatingPlanService {

    SeatingPlan generateSeatingPlan(Long examSessionId, Long roomId);

    List<SeatingPlan> getPlansBySession(Long examSessionId);
}
