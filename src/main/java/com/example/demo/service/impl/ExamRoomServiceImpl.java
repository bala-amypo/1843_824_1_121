package com.example.demo.service.impl;

import com.example.demo.service.ExamRoomService;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.model.ExamRoom;
import com.example.demo.exception.ApiException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository roomRepo;

    // ✅ REQUIRED constructor (NO Lombok)
    public ExamRoomServiceImpl(ExamRoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public ExamRoom addRoom(ExamRoom room) {
        if (room.getRows() == null || room.getRows() <= 0)
            throw new ApiException("Invalid number of rows");

        if (room.getColumns() == null || room.getColumns() <= 0)
            throw new ApiException("Invalid number of columns");

        if (roomRepo.findByRoomNumber(room.getRoomNumber()).isPresent())
            throw new ApiException("Room with this number already exists");

        room.ensureCapacityMatches();
        return roomRepo.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return roomRepo.findAll();
    }
}
