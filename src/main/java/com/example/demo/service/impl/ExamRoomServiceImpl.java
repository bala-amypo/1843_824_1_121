package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;

import java.util.List;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository examRoomRepository;

    // ✅ REQUIRED by tests
    public ExamRoomServiceImpl() {
        this.examRoomRepository = null;
    }

    public ExamRoomServiceImpl(ExamRoomRepository examRoomRepository) {
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public ExamRoom saveExamRoom(ExamRoom examRoom) {
        return examRoomRepository.save(examRoom);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return examRoomRepository.findAll();
    }
}

