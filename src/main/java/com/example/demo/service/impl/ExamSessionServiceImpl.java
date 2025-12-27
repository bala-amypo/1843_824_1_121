// package com.example.demo.service;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import com.example.demo.model.ExamSession;
// import com.example.demo.repository.ExamSessionRepository;

// import java.util.List;

// @Service
// public class ExamSessionServiceImpl implements ExamSessionService {

//     private final ExamSessionRepository repository;

//     public ExamSessionServiceImpl(ExamSessionRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public ExamSession saveSession(ExamSession session) {
//         return repository.save(session);
//     }

//     @Override
//     public List<ExamSession> getAllSessions() {
//         return repository.findAll();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.service.ExamSessionService;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.model.ExamSession;
import com.example.demo.model.Student;
import com.example.demo.exception.ApiException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    private final ExamSessionRepository sessionRepo;
    private final StudentRepository studentRepo;

    @Override
    public ExamSession createSession(ExamSession session) {
        if (session.getExamDate().isBefore(LocalDate.now()))
            throw new ApiException("Cannot create session for past date");
        if (session.getStudents() == null || session.getStudents().isEmpty())
            throw new ApiException("At least 1 student required for session");

        // Optional: ensure students exist in DB
        HashSet<Student> validStudents = new HashSet<>();
        for (Student s : session.getStudents()) {
            studentRepo.findById(s.getId()).ifPresent(validStudents::add);
        }
        session.setStudents(validStudents);

        return sessionRepo.save(session);
    }

    @Override
    public ExamSession getSession(Long id) {
        return sessionRepo.findById(id).orElseThrow(() -> new ApiException("Session not found"));
    }
}
