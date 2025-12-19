package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.service.ExamRoomService;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository examRoomRepository;

    @Autowired
    public ExamRoomServiceImpl(ExamRoomRepository examRoomRepository) {
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public ExamRoom saveExamRoom(ExamRoom examRoom) {
        return examRoomRepository.save(examRoom);
    }

    @Override
    public List<ExamRoom> getAllExamRooms() {
        return examRoomRepository.findAll();
    }

    @Override
    public ExamRoom getExamRoomById(Long id) {
        Optional<ExamRoom> room = examRoomRepository.findById(id);
        return room.orElse(null);  // or throw exception if not found
    }

    @Override
    public void deleteExamRoom(Long id) {
        examRoomRepository.deleteById(id);
    }
}
