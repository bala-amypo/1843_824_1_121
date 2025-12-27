// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.ExamRoom;
// import com.example.demo.repository.ExamRoomRepository;
// import com.example.demo.service.ExamRoomService;

// @Service
// public class ExamRoomServiceImpl implements ExamRoomService {

//     private final ExamRoomRepository examRoomRepository;

//     // REQUIRED
//     public ExamRoomServiceImpl() {
//         this.examRoomRepository = null;
//     }

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
package com.example.demo.service.impl;

import com.example.demo.service.ExamRoomService;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.model.ExamRoom;
import com.example.demo.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamRoomServiceImpl implements ExamRoomService {

    private final ExamRoomRepository roomRepo;

    @Override
    public ExamRoom addRoom(ExamRoom room) {
        if (room.getRows() == null || room.getRows() <= 0)
            throw new ApiException("Invalid number of rows");
        if (room.getColumns() == null || room.getColumns() <= 0)
            throw new ApiException("Invalid number of columns");
        if (roomRepo.findByRoomNumber(room.getRoomNumber()).isPresent())
            throw new ApiException("Room with this number already exists");

        room.ensureCapacityMatches();
        return roomRepo.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms() {
        return roomRepo.findAll();
    }
}
