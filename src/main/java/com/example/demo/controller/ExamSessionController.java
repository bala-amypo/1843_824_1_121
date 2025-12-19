package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.ExamSession;
import com.example.demo.service.ExamSessionService;

@RestController
@RequestMapping("/sessions")
public class ExamSessionController {

    @Autowired
    private ExamSessionService examSessionService;

    // POST /sessions — create new exam session
    @PostMapping
    public ExamSession createSession(@RequestBody ExamSession session) {
        return examSessionService.createSession(session);
    }

    // GET /sessions/{id} — get session details
    @GetMapping("/{id}")
    public ExamSession getSession(@PathVariable Long id) {
        return examSessionService.getSession(id);
    }
}
