// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import com.example.demo.service.ExamSessionService;
// import com.example.demo.repository.ExamSessionRepository;
// import com.example.demo.model.ExamSession;

// @Service
// public class ExamSessionServiceImpl implements ExamSessionService {

//     private final ExamSessionRepository examSessionRepository;

//     public ExamSessionServiceImpl(ExamSessionRepository examSessionRepository) {
//         this.examSessionRepository = examSessionRepository;
//     }

  
//     public ExamSession createSession(ExamSession session) {
//         return examSessionRepository.save(session);
//     }

   
//     public ExamSession getSession(Long sessionId) {
//         return examSessionRepository.findById(sessionId).orElse(null);
//     }
// }
