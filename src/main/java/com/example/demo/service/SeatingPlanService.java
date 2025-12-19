package com.example.demo.service;

import com.example.demo.model.SeatingPlan;

public interface SeatingPlanService {

    SeatingPlan generatePlan(Long sessionId);

    SeatingPlan getPlan(Long planId);

    SeatingPlan getPlanBySession(Long sessionId);
}
