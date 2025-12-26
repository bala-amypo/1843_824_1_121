package com.example.demo.service;

import com.example.demo.model.SeatingPlan;

import java.util.List;
public interface SeatingPlanService {

    SeatingPlan generateSeatingPlan(Long sessionId, Long roomId);

    SeatingPlan getPlan(Long planId);

    List<SeatingPlan> getPlansBySession(Long sessionId);
}
