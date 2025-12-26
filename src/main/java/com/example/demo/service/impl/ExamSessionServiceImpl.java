package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.ExamSession;
import com.example.demo.repository.ExamSessionRepository;

import java.util.List;

@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    private final ExamSessionRepository repository;

    public ExamSessionServiceImpl(ExamSessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExamSession saveSession(ExamSession session) {
        return repository.save(session);
    }

    @Override
    public List<ExamSession> getAllSessions() {
        return repository.findAll();
    }
}
