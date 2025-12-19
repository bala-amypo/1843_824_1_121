package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.ExamSession;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.service.ExamSessionService;

import java.time.LocalDate;

@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    @Autowired
    private ExamSessionRepository examSessionRepository;

    @Override
    public ExamSession createSession(ExamSession session) {
        // Validation: date cannot be in the past
        if (session.getExamDate() != null && session.getExamDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Exam date cannot be in the past");
        }

        // Validation: at least 1 student required
        if (session.getStudents() == null || session.getStudents().isEmpty()) {
            throw new RuntimeException("At least 1 student is required");
        }

        // JPA will handle cascade save for new/existing students
        return examSessionRepository.save(session);
    }

    @Override
    public ExamSession getSession(Long sessionId) {
        return examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("ExamSession not found with id: " + sessionId));
    }
}
