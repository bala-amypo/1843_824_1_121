// package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ExamSession;
import com.example.demo.service.ExamSessionService;

@RestController
@RequestMapping("/exam-sessions")
public class ExamSessionController {

    private final ExamSessionService examSessionService;

    // ✅ Constructor injection
    public ExamSessionController(ExamSessionService examSessionService) {
        this.examSessionService = examSessionService;
    }

    // ✅ Save Exam Session
    @PostMapping
    public ResponseEntity<ExamSession> saveSession(@RequestBody ExamSession session) {
        return ResponseEntity.ok(examSessionService.saveSession(session));
    }

    // ✅ Get All Exam Sessions
    @GetMapping
    public ResponseEntity<List<ExamSession>> getAllSessions() {
        return ResponseEntity.ok(examSessionService.getAllSessions());
    }
}
