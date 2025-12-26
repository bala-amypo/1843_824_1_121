package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;

import java.util.List;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository repository;

    @Autowired
    public ExamRoomServiceImpl(ExamRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExamRoom addRoom(ExamRoom room) {
        return repository.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return repository.findAll();
    }
}
