package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.service.ExamSessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    private final ExamSessionRepository examSessionRepository;

    public ExamSessionServiceImpl(ExamSessionRepository examSessionRepository) {
        this.examSessionRepository = examSessionRepository;
    }

    @Override
    public ExamSession createSession(ExamSession session) {
        // Rule 1: Exam date cannot be in the past
        if (session.getExamDate() == null || session.getExamDate().isBefore(LocalDate.now())) {
            throw new ApiException("Exam date cannot be in the past or null");
        }

        // Rule 2: At least one student is required
        if (session.getStudents() == null || session.getStudents().isEmpty()) {
            throw new ApiException("At least one student is required for an exam session");
        }

        // Save to database
        return examSessionRepository.save(session);
    }

    @Override
    public ExamSession getSession(Long sessionId) {
        return examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("Exam session not found with ID: " + sessionId));
    }
}
