// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import java.util.List;

// import com.example.demo.service.SeatingPlanService;
// import com.example.demo.repository.SeatingPlanRepository;
// import com.example.demo.repository.ExamSessionRepository;
// import com.example.demo.repository.ExamRoomRepository;
// import com.example.demo.model.SeatingPlan;
// import com.example.demo.model.ExamSession;

// @Service
// public class SeatingPlanServiceImpl implements SeatingPlanService {

//     private final SeatingPlanRepository seatingPlanRepository;
//     private final ExamSessionRepository examSessionRepository;
//     private final ExamRoomRepository examRoomRepository;

//     public SeatingPlanServiceImpl(
//             SeatingPlanRepository seatingPlanRepository,
//             ExamSessionRepository examSessionRepository,
//             ExamRoomRepository examRoomRepository) {

//         this.seatingPlanRepository = seatingPlanRepository;
//         this.examSessionRepository = examSessionRepository;
//         this.examRoomRepository = examRoomRepository;
//     }

//     @Override
//     public SeatingPlan generatePlan(Long sessionId) {

//         ExamSession session = examSessionRepository.findById(sessionId)
//                 .orElseThrow(() -> new RuntimeException("Session not found"));

//         if (examRoomRepository.findAll().isEmpty()) {
//             throw new RuntimeException("No room available");
//         }

//         SeatingPlan plan = new SeatingPlan();
//         plan.setSessionId(sessionId);
//         plan.setPlanDetails("Auto-generated seating plan");

//         return seatingPlanRepository.save(plan);
//     }

  
//     public SeatingPlan getPlan(Long planId) {
//         return seatingPlanRepository.findById(planId)
//                 .orElseThrow(() -> new RuntimeException("Plan not found"));
//     }

    
//     public List<SeatingPlan> getPlansBySession(Long sessionId) {
//         return seatingPlanRepository.findBySessionId(sessionId);
//     }
// }
