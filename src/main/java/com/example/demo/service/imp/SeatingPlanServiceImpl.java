package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.SeatingPlanService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final SeatingPlanRepository seatingPlanRepository;
    private final ExamSessionRepository examSessionRepository;
    private final ExamRoomRepository examRoomRepository;

    public SeatingPlanServiceImpl(
            SeatingPlanRepository seatingPlanRepository,
            ExamSessionRepository examSessionRepository,
            ExamRoomRepository examRoomRepository) {
        this.seatingPlanRepository = seatingPlanRepository;
        this.examSessionRepository = examSessionRepository;
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public SeatingPlan generatePlan(Long sessionId) {

        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        // 🔹 Find any room that fits capacity
        ExamRoom room = examRoomRepository.findFirstByCapacityGreaterThanEqual(
                session.getTotalStudents()
        ).orElseThrow(() -> new RuntimeException("No room available"));

        // 🔹 Generate simple arrangement JSON
        String arrangementJson = "{ \"session\": " + sessionId +
                ", \"room\": \"" + room.getName() + "\" }";

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(room);
        plan.setArrangementJson(arrangementJson);

        return seatingPlanRepository.save(plan);
    }

    @Override
    public SeatingPlan getPlan(Long planId) {
        return seatingPlanRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return seatingPlanRepository.findByExamSessionId(sessionId);
    }
}
