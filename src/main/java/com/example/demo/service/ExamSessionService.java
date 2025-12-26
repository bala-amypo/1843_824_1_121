package com.example.demo.service;

import com.example.demo.model.ExamSession;

import java.util.List;

public interface ExamSessionService {
    ExamSession createSession(ExamSession session);
    ExamSession getSession(Long sessionId);
    List<ExamSession> getAllSessions(); // optional if tests call it
}
