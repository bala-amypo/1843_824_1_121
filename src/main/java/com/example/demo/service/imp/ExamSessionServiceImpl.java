package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

        List<ExamRoom> rooms = examRoomRepository.findAll();

        if (rooms.isEmpty()) {
            throw new RuntimeException("No room available");
        }

        ExamRoom selectedRoom = rooms.get(0); // simple logic

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(selectedRoom);

        // Dummy arrangement (can be replaced with real logic)
        plan.setArrangementJson("{\"status\":\"generated\"}");

        return seatingPlanRepository.save(plan);
    }

    @Override
    public SeatingPlan getPlan(Long planId) {
        return seatingPlanRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return seatingPlanRepository.findByExamSession_Id(sessionId);
    }
}
