public interface ExamSessionService {

    ExamSession saveSession(ExamSession session);

    List<ExamSession> getAllSessions();
}
