package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;

@RestController
public class SeatingPlanController {

    private final SeatingPlanService service;

    public SeatingPlanController(SeatingPlanService service) {
        this.service = service;
    }

    @PostMapping("/seating-plan")
    public SeatingPlan generate(
            @RequestParam Long examSessionId,
            @RequestParam Long roomId) {

        return service.generateSeatingPlan(examSessionId, roomId);
    }

    @GetMapping("/seating-plan")
    public List<SeatingPlan> getAll(@RequestParam Long examSessionId) {
        return service.getPlansBySession(examSessionId);
    }
}
