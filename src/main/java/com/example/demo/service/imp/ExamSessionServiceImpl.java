package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.model.Student;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ExamSessionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    private final ExamSessionRepository examSessionRepository;
    private final StudentRepository studentRepository;

    public ExamSessionServiceImpl(ExamSessionRepository examSessionRepository,
                                  StudentRepository studentRepository) {
        this.examSessionRepository = examSessionRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public ExamSession createSession(ExamSession session) {
        // Validate exam date
        if (session.getExamDate() == null || session.getExamDate().isBefore(LocalDate.now())) {
            throw new ApiException("Exam date cannot be in the past or null");
        }

        // Validate students list
        if (session.getStudents() == null || session.getStudents().isEmpty()) {
            throw new ApiException("At least one student is required for an exam session");
        }

        // Ensure all students exist or persist new ones
        List<Student> students = session.getStudents().stream().map(student -> {
            if (student.getId() != null) {
                // Existing student: fetch from DB
                return studentRepository.findById(student.getId())
                        .orElseThrow(() -> new ApiException("Student not found with id: " + student.getId()));
            } else {
                // New student: save to DB
                return studentRepository.save(student);
            }
        }).toList();

        session.setStudents(students);

        return examSessionRepository.save(session);
    }

    @Override
    public ExamSession getSession(Long sessionId) {
        return examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("Exam session not found with ID: " + sessionId));
    }
}
