package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.model.ExamSession;

@Service
public class ExamSessionService {

    @Autowired
    private ExamSessionRepository examSessionRepository;

    public ExamSession createSession(ExamSession examSession) {
        // JPA handles students because of CascadeType.PERSIST/MERGE
        return examSessionRepository.save(examSession);
    }
}
