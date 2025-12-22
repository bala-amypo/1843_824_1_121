package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ExamRoom;
import com.example.demo.service.ExamRoomService;

import java.util.List;

@RestController
@RequestMapping("/api/exam-rooms")
public class ExamRoomController {

    private final ExamRoomService examRoomService;

    @Autowired
    public ExamRoomController(ExamRoomService examRoomService) {
        this.examRoomService = examRoomService;
    }

    
    @PostMapping
    public ExamRoom addRoom(@RequestBody ExamRoom examRoom) {
        return examRoomService.addRoom(examRoom);
    }

    @GetMapping
    public List<ExamRoom> getAllRooms() {
        return examRoomService.getAllRooms();
    }
}
