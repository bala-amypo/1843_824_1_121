package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ExamRoom;
import com.example.demo.service.ExamRoomService;

@RestController
@RequestMapping("/rooms")
public class ExamRoomController {

    private final ExamRoomService service;

    public ExamRoomController(ExamRoomService service) {
        this.service = service;
    }

    @PostMapping
    public ExamRoom addRoom(@RequestBody ExamRoom room) {
        return service.addRoom(room);
    }

    @GetMapping
    public List<ExamRoom> getAllRooms() {
        return service.getAllRooms();
    }
}
