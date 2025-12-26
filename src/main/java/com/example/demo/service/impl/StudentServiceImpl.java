// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.exception.ApiException;
// import com.example.demo.model.Student;
// import com.example.demo.repository.StudentRepository;
// import com.example.demo.service.StudentService;

// @Service
// public class StudentServiceImpl implements StudentService {

//     private final StudentRepository studentRepository;

//     // REQUIRED by tests
//     public StudentServiceImpl() {
//         this.studentRepository = null;
//     }

//     public StudentServiceImpl(StudentRepository studentRepository) {
//         this.studentRepository = studentRepository;
//     }

//     @Override
//     public Student saveStudent(Student student) {
//         return studentRepository.save(student);
//     }

//     @Override
//     public Student getByRollNumber(String rollNumber) {
//         return studentRepository.findByRollNumber(rollNumber)
//                 .orElseThrow(() -> new ApiException("student not found"));
//     }

//     @Override
//     public List<Student> getAllStudents() {
//         return studentRepository.findAll();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepository;
import com.example.demo.model.Student;
import com.example.demo.exception.ApiException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    @Override
    public Student addStudent(Student student) {
        if (student.getRollNumber() == null || student.getRollNumber().isEmpty())
            throw new ApiException("Roll number required");
        if (student.getYear() == null || student.getYear() < 1 || student.getYear() > 5)
            throw new ApiException("Invalid year");
        if (studentRepo.findByRollNumber(student.getRollNumber()).isPresent())
            throw new ApiException("Student with this roll number already exists");
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
