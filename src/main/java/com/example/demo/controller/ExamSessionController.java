
package com.example.demo.controller;

import com.example.demo.service.ExamSessionService;
import com.example.demo.model.ExamSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
@AllArgsConstructor
public class ExamSessionController {

    private final ExamSessionService sessionService;

    @PostMapping("/create")
    public ResponseEntity<ExamSession> create(@RequestBody ExamSession session) {
        return ResponseEntity.ok(sessionService.createSession(session));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamSession> get(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.getSession(id));
    }
}
