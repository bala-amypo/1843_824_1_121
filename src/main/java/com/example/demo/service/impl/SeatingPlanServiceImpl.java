package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamRoom;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final SeatingPlanRepository seatingPlanRepository;
    private final ExamSessionRepository examSessionRepository;
    private final ExamRoomRepository examRoomRepository;

    // Constructor for Spring DI
    public SeatingPlanServiceImpl(SeatingPlanRepository seatingPlanRepository,
                                  ExamSessionRepository examSessionRepository,
                                  ExamRoomRepository examRoomRepository) {
        this.seatingPlanRepository = seatingPlanRepository;
        this.examSessionRepository = examSessionRepository;
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public SeatingPlan generateSeatingPlan(Long sessionId, Long roomId) {

        // Fetch session
        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("Session not found"));

        // Fetch room
        ExamRoom room = examRoomRepository.findById(roomId)
                .orElseThrow(() -> new ApiException("Room not found"));

        List<com.example.demo.model.Student> students = session.getStudents();
        if (students == null || students.isEmpty()) {
            throw new ApiException("At least one student is required");
        }

        if (students.size() > room.getCapacity()) {
            throw new ApiException("Room capacity exceeded");
        }

        // Create seating plan
        SeatingPlan plan = new SeatingPlan();
        plan.setStudents(new ArrayList<>(students)); // FIX: use independent list
        plan.setGeneratedAt(LocalDateTime.now());
        plan.setExamSession(session);
        plan.setRoom(room);

        return seatingPlanRepository.save(plan);
    }

    @Override
    public SeatingPlan getPlan(Long planId) {
        return seatingPlanRepository.findById(planId)
                .orElseThrow(() -> new ApiException("Plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("Session not found"));

        return seatingPlanRepository.findByExamSession(session);
    }
}
