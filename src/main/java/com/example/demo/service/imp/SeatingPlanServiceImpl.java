package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ExamRoom;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final SeatingPlanRepository repository;

    public SeatingPlanServiceImpl(SeatingPlanRepository repository) {
        this.repository = repository;
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
        plan.setArrangementJson("{\"status\":\"generated\"}");

        return repository.save(plan);
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long examSessionId) {
        return repository.findAll();
    }
}
