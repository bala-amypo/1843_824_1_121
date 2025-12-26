package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ExamRoom;

public interface ExamRoomService {

    ExamRoom saveExamRoom(ExamRoom room);

    List<ExamRoom> getAllRooms();
}
