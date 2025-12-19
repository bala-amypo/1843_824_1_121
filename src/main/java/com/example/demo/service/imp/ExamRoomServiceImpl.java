package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.service.ExamRoomService;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    @Autowired
    private ExamRoomRepository examRoomRepository;

    @Override
    public ExamRoom addRoom(ExamRoom room) {

        // Rule 1: Room number must be unique
        if (examRoomRepository.findByRoomNumber(room.getRoomNumber()).isPresent()) {
            throw new ApiException("Room number already exists");
        }

        // Rule 2: Capacity = rows × columns
        int capacity = room.getRows() * room.getColumns();
        room.setCapacity(capacity);

        return examRoomRepository.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return examRoomRepository.findAll();
    }
}
