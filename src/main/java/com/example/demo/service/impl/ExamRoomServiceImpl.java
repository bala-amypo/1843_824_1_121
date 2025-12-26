package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;

import java.util.List;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository repository;

    public ExamRoomServiceImpl(ExamRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExamRoom saveExamRoom(ExamRoom examRoom) {
        return repository.save(examRoom);
    }

   @Override
   public List<ExamRoom> getAllRooms() {
        return examRoomRepository.findAll();
   }
 
}
