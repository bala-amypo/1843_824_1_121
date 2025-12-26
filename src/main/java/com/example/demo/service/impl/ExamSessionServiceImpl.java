// // package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.ExamSession;
// import com.example.demo.repository.ExamSessionRepository;
// import com.example.demo.repository.StudentRepository;
// import com.example.demo.service.ExamSessionService;

// @Service
// public class ExamSessionServiceImpl implements ExamSessionService {

//     private final ExamSessionRepository examSessionRepository;
//     private final StudentRepository studentRepository;

//     // ✅ REQUIRED BY TEST
//     public ExamSessionServiceImpl() {
//         this.examSessionRepository = null;
//         this.studentRepository = null;
//     }

//     // ✅ REQUIRED BY SPRING
//     public ExamSessionServiceImpl(ExamSessionRepository examSessionRepository,
//                                   StudentRepository studentRepository) {
//         this.examSessionRepository = examSessionRepository;
//         this.studentRepository = studentRepository;
//     }

//     @Override
//     public ExamSession saveSession(ExamSession session) {
//         return examSessionRepository.save(session);
//     }

//     @Override
//     public List<ExamSession> getAllSessions() {
//         return examSessionRepository.findAll();
//     }
// } 
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
    public ExamSession saveSession(ExamSession session) {
        return examSessionRepository.save(session);
    }

    @Override
    public List<ExamSession> getAllSessions() {
        return examSessionRepository.findAll();
    }
}
