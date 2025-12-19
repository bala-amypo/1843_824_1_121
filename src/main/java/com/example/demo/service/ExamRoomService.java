package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ExamRoom;

public interface ExamRoomService {

    ExamRoom saveExamRoom(ExamRoom examRoom);

    List<ExamRoom> getAllExamRooms();

    ExamRoom getExamRoomById(Long id);

    void deleteExamRoom(Long id);
}
