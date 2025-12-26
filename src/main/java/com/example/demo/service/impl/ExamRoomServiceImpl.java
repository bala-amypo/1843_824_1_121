package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.service.ExamRoomService;

// // @Service
// // public class ExamRoomServiceImpl implements ExamRoomService {

// //     @Autowired
// //     private ExamRoomRepository examRoomRepository;

// //     @Override
// //     public ExamRoom addRoom(ExamRoom room) {
// //         return examRoomRepository.save(room);
// //     }

// //     @Override
// //     public List<ExamRoom> getAllRooms() {
// //         return examRoomRepository.findAll();
// //     }
// // }
// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.ExamRoom;
// import com.example.demo.repository.ExamRoomRepository;
// import com.example.demo.service.ExamRoomService;

// @Service
// public class ExamRoomServiceImpl implements ExamRoomService {

//     private final ExamRoomRepository examRoomRepository;

//     // ✅ TEST EXPECTS NO-ARG CONSTRUCTOR
//     public ExamRoomServiceImpl() {
//         this.examRoomRepository = null;
//     }

//     // ✅ SPRING CONSTRUCTOR
//     public ExamRoomServiceImpl(ExamRoomRepository examRoomRepository) {
//         this.examRoomRepository = examRoomRepository;
//     }

//     @Override
//     public ExamRoom saveExamRoom(ExamRoom room) {
//         return examRoomRepository.save(room);
//     }

//     @Override
//     public List<ExamRoom> getAllRooms() {
//         return examRoomRepository.findAll();
//     }
// }

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository examRoomRepository;

    public ExamRoomServiceImpl(ExamRoomRepository examRoomRepository) {
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public ExamRoom saveExamRoom(ExamRoom room) {
        return examRoomRepository.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return examRoomRepository.findAll();
    }
}
