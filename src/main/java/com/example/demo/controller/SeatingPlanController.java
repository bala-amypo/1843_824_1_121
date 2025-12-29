
package com.example.demo.controller;

import com.example.demo.service.SeatingPlanService;
import com.example.demo.model.SeatingPlan;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@AllArgsConstructor
public class SeatingPlanController {

    private final SeatingPlanService planService;

    @PostMapping("/generate/{sessionId}")
    public ResponseEntity<SeatingPlan> generate(@PathVariable Long sessionId) {
        return ResponseEntity.ok(planService.generatePlan(sessionId));
    }

    @GetMapping("/{planId}")
    public ResponseEntity<SeatingPlan> get(@PathVariable Long planId) {
        return ResponseEntity.ok(planService.getPlan(planId));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<SeatingPlan>> list(@PathVariable Long sessionId) {
        return ResponseEntity.ok(planService.getPlansBySession(sessionId));
    }
}
