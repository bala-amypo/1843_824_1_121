// package com.example.demo.service.impl;

// import java.time.LocalDateTime;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// import org.springframework.stereotype.Service;

// import com.example.demo.exception.ApiException;
// import com.example.demo.model.ExamRoom;
// import com.example.demo.model.ExamSession;
// import com.example.demo.model.SeatingPlan;
// import com.example.demo.model.Student;
// import com.example.demo.repository.ExamRoomRepository;
// import com.example.demo.repository.ExamSessionRepository;
// import com.example.demo.repository.SeatingPlanRepository;
// import com.example.demo.service.SeatingPlanService;

// @Service
// public class SeatingPlanServiceImpl implements SeatingPlanService {

//     private final SeatingPlanRepository seatingPlanRepository;
//     private final ExamSessionRepository examSessionRepository;
//     private final ExamRoomRepository examRoomRepository;

//     public SeatingPlanServiceImpl(SeatingPlanRepository seatingPlanRepository,
//                                   ExamSessionRepository examSessionRepository,
//                                   ExamRoomRepository examRoomRepository) {
//         this.seatingPlanRepository = seatingPlanRepository;
//         this.examSessionRepository = examSessionRepository;
//         this.examRoomRepository = examRoomRepository;
//     }

//     @Override
//     public SeatingPlan generateSeatingPlan(Long sessionId, Long roomId) {
//         ExamSession session = examSessionRepository.findById(sessionId)
//                 .orElseThrow(() -> new ApiException("Session not found"));

//         ExamRoom room = examRoomRepository.findById(roomId)
//                 .orElseThrow(() -> new ApiException("Room not found"));

//         List<Student> studentList = session.getStudents();
//         if (studentList == null || studentList.isEmpty()) {
//             throw new ApiException("At least one student is required");
//         }

//         if (studentList.size() > room.getCapacity()) {
//             throw new ApiException("Room capacity exceeded");
//         }

//         SeatingPlan plan = new SeatingPlan();
//         plan.setExamSession(session);
//         plan.setRoom(room);
//         plan.setGeneratedAt(LocalDateTime.now());
//         plan.setStudents(new HashSet<>(studentList)); // <-- fixed type issue
//         plan.setArrangementJson("{\"studentCount\": " + studentList.size() + "}");

//         return seatingPlanRepository.save(plan);
//     }

//     @Override
//     public SeatingPlan getPlan(Long planId) {
//         return seatingPlanRepository.findById(planId)
//                 .orElseThrow(() -> new ApiException("Plan not found"));
//     }

//     @Override
//     public List<SeatingPlan> getPlansBySession(Long sessionId) {
//         ExamSession session = examSessionRepository.findById(sessionId)
//                 .orElseThrow(() -> new ApiException("Session not found"));

//         return seatingPlanRepository.findByExamSession(session);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.service.SeatingPlanService;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.model.SeatingPlan;
import com.example.demo.model.ExamSession;
import com.example.demo.model.ExamRoom;
import com.example.demo.exception.ApiException;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository sessionRepo;
    private final SeatingPlanRepository planRepo;
    private final ExamRoomRepository roomRepo;

    @Override
    public SeatingPlan generatePlan(Long sessionId) {
        ExamSession session = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new ApiException("Session not found"));

        List<ExamRoom> rooms = roomRepo.findAll();
        if (rooms.isEmpty())
            throw new ApiException("No room available");

        ExamRoom selectedRoom = rooms.get(0); // simple first-fit allocation
        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(selectedRoom);
        plan.setGeneratedAt(LocalDateTime.now());

        // generate simple JSON arrangement
        String json = "{\"students\":" + session.getStudents().stream()
                .map(s -> "\"" + s.getRollNumber() + "\"").toList() + "}";
        plan.setArrangementJson(json);

        return planRepo.save(plan);
    }

    @Override
    public SeatingPlan getPlan(Long planId) {
        return planRepo.findById(planId).orElseThrow(() -> new ApiException("Plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return planRepo.findByExamSessionId(sessionId);
    }
}
