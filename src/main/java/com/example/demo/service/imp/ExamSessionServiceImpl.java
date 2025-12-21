package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.ExamSession;
import com.example.demo.repository.ExamSessionRepository;
import java.util.Optional;

@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    @Autowired
    private ExamSessionRepository examSessionRepository;

    @Override
    public ExamSession createSession(ExamSession examSession) {
        // JPA handles students because of CascadeType.PERSIST/MERGE
        return examSessionRepository.save(examSession);
    }

    @Override
    public ExamSession getSession(Long sessionId) {
        Optional<ExamSession> session = examSessionRepository.findById(sessionId);
        return session.orElse(null); // or throw exception if you want
    }
}
