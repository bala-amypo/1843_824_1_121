// package com.example.demo.service;

// import com.example.demo.model.ExamSession;

// import java.util.List;

// public interface ExamSessionService {

//     ExamSession saveSession(ExamSession session);

//     List<ExamSession> getAllSessions();
// }


package com.example.demo.service;

import com.example.demo.model.ExamSession;

public interface ExamSessionService {
    ExamSession createSession(ExamSession session);
    ExamSession getSession(Long id);
}
