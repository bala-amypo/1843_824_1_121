package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ExamRoom;

public interface ExamRoomService {

    ExamRoom saveExamRoom(ExamRoom examRoom);

    // ✅ MUST MATCH TEST CASE
    List<ExamRoom> getAllRooms();
}
