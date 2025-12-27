
package com.example.demo.controller;

import com.example.demo.service.ExamRoomService;
import com.example.demo.model.ExamRoom;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class ExamRoomController {

    private final ExamRoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<ExamRoom> add(@RequestBody ExamRoom room) {
        return ResponseEntity.ok(roomService.addRoom(room));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ExamRoom>> list() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }
}
