package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ExamRoom;
import com.example.demo.entity.ExamSession;
import com.example.demo.entity.SeatingPlan;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final SeatingPlanRepository seatingPlanRepository;

    public SeatingPlanServiceImpl(SeatingPlanRepository seatingPlanRepository) {
        this.seatingPlanRepository = seatingPlanRepository;
    }

    @Override
    public SeatingPlan generateSeatingPlan(Long examSessionId, Long roomId) {

        ExamSession session = new ExamSession();
        session.setId(examSessionId);

        ExamRoom room = new ExamRoom();
        room.setId(roomId);

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(room);
        plan.setArrangementJson("{\"message\":\"Sample seating plan\"}");

        return seatingPlanRepository.save(plan);
    }
}
