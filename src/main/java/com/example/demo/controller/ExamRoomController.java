// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.ExamRoom;
// import com.example.demo.service.ExamRoomService;

// @RestController
// @RequestMapping("/exam-rooms")
// public class ExamRoomController {

//     private final ExamRoomService examRoomService;

//     @Autowired
//     public ExamRoomController(ExamRoomService examRoomService) {
//         this.examRoomService = examRoomService;
//     }

//     // ✅ SAVE ROOM
//     @PostMapping
//     public ExamRoom saveExamRoom(@RequestBody ExamRoom room) {
//         return examRoomService.saveExamRoom(room);
//     }

//     // ✅ GET ALL ROOMS (THIS FIXES THE ERROR)
//     @GetMapping
//     public List<ExamRoom> getAllRooms() {
//         return examRoomService.getAllRooms();
//     }
// }
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
