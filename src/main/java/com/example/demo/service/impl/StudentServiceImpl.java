package com.example.demo.service.impl;

import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepository;
import com.example.demo.model.Student;
import com.example.demo.exception.ApiException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    // ✅ REQUIRED constructor for Spring
    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

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
