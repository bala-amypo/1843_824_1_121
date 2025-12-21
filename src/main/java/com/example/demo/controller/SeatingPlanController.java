package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;

@RestController
@RequestMapping("/plans")
public class SeatingPlanController {

    private final SeatingPlanService service;

    public SeatingPlanController(SeatingPlanService service) {
        this.service = service;
    }

    // POST /plans/generate/{sessionId}
    @PostMapping("/generate/{sessionId}")
    public SeatingPlan generate(@PathVariable Long sessionId) {
        return service.generateSeatingPlan(sessionId);
    }

    // GET /plans/{planId}
    @GetMapping("/{planId}")
    public SeatingPlan getPlan(@PathVariable Long planId) {
        return service.getPlan(planId);
    }

    // GET /plans/session/{sessionId}
    @GetMapping("/session/{sessionId}")
    public List<SeatingPlan> getPlansBySession(@PathVariable Long sessionId) {
        return service.getPlansBySession(sessionId);
    }
}
