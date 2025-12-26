package com.example.demo.service.impl;

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

    public SeatingPlanServiceImpl(
            SeatingPlanRepository seatingPlanRepository,
            ExamSessionRepository examSessionRepository,
            ExamRoomRepository examRoomRepository) {
        this.seatingPlanRepository = seatingPlanRepository;
        this.examSessionRepository = examSessionRepository;
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public SeatingPlan generateSeatingPlan(Long sessionId, Long roomId) {

        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));

        ExamRoom room = examRoomRepository.findById(roomId)
                .orElseThrow(() -> new ApiException("room not found"));

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(room);
        plan.setArrangementJson("{\"status\":\"generated\"}");

        return seatingPlanRepository.save(plan);
    }

    @Override
    public SeatingPlan getPlan(Long planId) {
        return seatingPlanRepository.findById(planId)
                .orElseThrow(() -> new ApiException("plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));

        return seatingPlanRepository.findByExamSession(session);
    }
}

