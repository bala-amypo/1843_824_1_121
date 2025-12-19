package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // Get all exam rooms
    @GetMapping
    public List<ExamRoom> getAllExamRooms() {
        return examRoomService.getAllExamRooms();  // ✅ fixed
    }

    // Get an exam room by ID
    @GetMapping("/{id}")
    public ResponseEntity<ExamRoom> getExamRoomById(@PathVariable Long id) {
        ExamRoom room = examRoomService.getExamRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new exam room
    @PostMapping
    public ExamRoom createExamRoom(@RequestBody ExamRoom examRoom) {
        return examRoomService.saveExamRoom(examRoom);  // ✅ fixed
    }

    // Update an existing exam room
    @PutMapping("/{id}")
    public ResponseEntity<ExamRoom> updateExamRoom(@PathVariable Long id, @RequestBody ExamRoom examRoom) {
        ExamRoom existingRoom = examRoomService.getExamRoomById(id);
        if (existingRoom != null) {
            existingRoom.setRoomNumber(examRoom.getRoomNumber());
            existingRoom.setRows(examRoom.getRows());
            existingRoom.setColumns(examRoom.getColumns());
            existingRoom.setCapacity(examRoom.getRows() * examRoom.getColumns());
            ExamRoom updatedRoom = examRoomService.saveExamRoom(existingRoom);
            return ResponseEntity.ok(updatedRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an exam room
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamRoom(@PathVariable Long id) {
        ExamRoom existingRoom = examRoomService.getExamRoomById(id);
        if (existingRoom != null) {
            examRoomService.deleteExamRoom(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
