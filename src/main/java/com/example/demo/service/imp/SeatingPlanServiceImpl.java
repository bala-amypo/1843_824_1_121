package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamRoom;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final SeatingPlanRepository seatingPlanRepository;
    private final ExamSessionRepository examSessionRepository;

    public SeatingPlanServiceImpl(SeatingPlanRepository seatingPlanRepository,
                                  ExamSessionRepository examSessionRepository) {
        this.seatingPlanRepository = seatingPlanRepository;
        this.examSessionRepository = examSessionRepository;
    }

    @Override
    public SeatingPlan generateSeatingPlan(Long sessionId) {

        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));

        if (session.getStudents() == null || session.getStudents().isEmpty()) {
            throw new ApiException("at least 1 student");
        }

        ExamRoom room = session.getRoom();
        if (room == null) {
            throw new ApiException("no room");
        }

        if (session.getStudents().size() > room.getCapacity()) {
            throw new ApiException("room capacity exceeded");
        }

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(room);

        // simple arrangement JSON
        plan.setArrangementJson(
                "{ \"studentCount\": " + session.getStudents().size() + " }"
        );

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
