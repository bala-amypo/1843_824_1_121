// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.SeatingPlan;
// import com.example.demo.service.SeatingPlanService;

// @RestController
// @RequestMapping("/seating-plan")
// public class SeatingPlanController {

//     private final SeatingPlanService service;

//     public SeatingPlanController(SeatingPlanService service) {
//         this.service = service;
//     }

//     // POST /seating-plan?examSessionId=1&roomId=2
//     @PostMapping
//     public SeatingPlan generate(
//             @RequestParam Long examSessionId,
//             @RequestParam Long roomId) {

//         return service.generateSeatingPlan(examSessionId, roomId);
//     }

//     // GET /seating-plan?examSessionId=1
//     @GetMapping
//     public List<SeatingPlan> getAll(@RequestParam Long examSessionId) {
//         return service.getPlansBySession(examSessionId);
//     }

//     // GET /seating-plan/{planId}
//     @GetMapping("/{planId}")
//     public SeatingPlan getOne(@PathVariable Long planId) {
//         return service.getPlan(planId);
//     }
// }
