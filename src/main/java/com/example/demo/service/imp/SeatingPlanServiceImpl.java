package com.example.demo.service.impl;

import com.example.demo.model.ExamRoom;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository examSessionRepository;
    private final ExamRoomRepository examRoomRepository;
    private final SeatingPlanRepository seatingPlanRepository;

    public SeatingPlanServiceImpl(ExamSessionRepository examSessionRepository,
                                  ExamRoomRepository examRoomRepository,
                                  SeatingPlanRepository seatingPlanRepository) {
        this.examSessionRepository = examSessionRepository;
        this.examRoomRepository = examRoomRepository;
        this.seatingPlanRepository = seatingPlanRepository;
    }

    // ===============================
    // Generate Seating Plan
    // ===============================
    @Override
    public SeatingPlan generatePlan(Long sessionId) {

        // 1. Find Exam Session
        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Exam session not found"));

        // 2. Find available room
        Optional<ExamRoom> roomOpt = examRoomRepository.findFirstByOrderByCapacityDesc();

        if (roomOpt.isEmpty()) {
            throw new RuntimeException("No room available");
        }

        ExamRoom room = roomOpt.get();

        // 3. Generate seating arrangement (simple JSON placeholder)
        String arrangementJson =
                "{ \"sessionId\": " + sessionId + ", \"room\": \"" + room.getRoomNumber() + "\" }";

        // 4. Save seating plan
        SeatingPlan plan = new SeatingPlan(session, room, arrangementJson);
        return seatingPlanRepository.save(plan);
    }

    // ===============================
    // Get Seating Plan by Plan ID
    // ===============================
    @Override
    public SeatingPlan getPlan(Long planId) {
        return seatingPlanRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
    }

    // ===============================
    // Get Seating Plan by Session ID
    // ===============================
    @Override
    public SeatingPlan getPlanBySession(Long sessionId) {

        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Exam session not found"));

        return seatingPlanRepository.findByExamSession(session)
                .orElseThrow(() -> new RuntimeException("Plan not found for this session"));
    }
}
