package com.example.demo.service;

import com.example.demo.model.ExamSession;

public interface ExamSessionService {

    // Create a new exam session
    ExamSession createSession(ExamSession session);

    // Get a session by ID
    ExamSession getSession(Long sessionId);
}
