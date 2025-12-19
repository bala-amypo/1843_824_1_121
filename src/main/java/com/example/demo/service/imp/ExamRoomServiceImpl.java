package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.service.ExamRoomService;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository examRoomRepository;

    public ExamRoomServiceImpl(ExamRoomRepository examRoomRepository) {
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public ExamRoom addRoom(ExamRoom room) {

        // 🔹 Rule: roomNumber must be unique
        if (examRoomRepository.findByRoomNumber(room.getRoomNumber()).isPresent()) {
            throw new ApiException("room number exists");
        }

        return examRoomRepository.save(room);
    }
}
