package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;

@RestController
@RequestMapping("/seating-plan")
public class SeatingPlanController {

    private final SeatingPlanService service;

    public SeatingPlanController(SeatingPlanService service) {
        this.service = service;
    }

    
    @PostMapping
    public SeatingPlan generate(
            @RequestParam Long examSessionId,
            @RequestParam Long roomId) {

        return service.generateSeatingPlan(examSessionId, roomId);
    }

   
    @GetMapping
    public List<SeatingPlan> getAll(@RequestParam Long examSessionId) {
        return service.getPlansBySession(examSessionId);
    }

   
    @GetMapping("/{planId}")
    public SeatingPlan getOne(@PathVariable Long planId) {
        return service.getPlan(planId);
    }
}
