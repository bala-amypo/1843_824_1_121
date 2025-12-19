package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;

@RestController
@RequestMapping("/plans")
public class SeatingPlanController {

    private final SeatingPlanService seatingPlanService;

    public SeatingPlanController(SeatingPlanService seatingPlanService) {
        this.seatingPlanService = seatingPlanService;
    }

    @PostMapping("/generate/{sessionId}")
    public SeatingPlan generatePlan(@PathVariable Long sessionId) {
        return seatingPlanService.generatePlan(sessionId);
    }

    @GetMapping("/{planId}")
    public SeatingPlan getPlan(@PathVariable Long planId) {
        return seatingPlanService.getPlan(planId);
    }

    // ✅ FIXED METHOD
    @GetMapping("/session/{sessionId}")
    public SeatingPlan getPlanBySession(@PathVariable Long sessionId) {
        return seatingPlanService.getPlanBySession(sessionId);
    }
}
