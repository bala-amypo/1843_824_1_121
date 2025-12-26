// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.ExamRoom;
// import com.example.demo.service.ExamRoomService;

// import java.util.List;

// @RestController
// @RequestMapping("/api/exam-rooms")
// public class ExamRoomController {

//     private final ExamRoomService examRoomService;

//     @Autowired
//     public ExamRoomController(ExamRoomService examRoomService) {
//         this.examRoomService = examRoomService;
//     }

    
//     @PostMapping
//     public ExamRoom addRoom(@RequestBody ExamRoom examRoom) {
//         return examRoomService.addRoom(examRoom);
//     }

//     @GetMapping
//     public List<ExamRoom> getAllRooms() {
//         return examRoomService.getAllRooms();
//     }
// }
package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ExamRoom;
import com.example.demo.service.ExamRoomService;

@RestController
@RequestMapping("/exam-rooms")
public class ExamRoomController {

    private final ExamRoomService examRoomService;

    // ✅ Constructor required by Spring
    public ExamRoomController(ExamRoomService examRoomService) {
        this.examRoomService = examRoomService;
    }

    // ✅ Save Exam Room
    @PostMapping
    public ResponseEntity<ExamRoom> saveExamRoom(@RequestBody ExamRoom room) {
        return ResponseEntity.ok(examRoomService.saveExamRoom(room));
    }

    // ✅ Get All Exam Rooms
    @GetMapping
    public ResponseEntity<List<ExamRoom>> getAllRooms() {
        return ResponseEntity.ok(examRoomService.getAllRooms());
    }
}
