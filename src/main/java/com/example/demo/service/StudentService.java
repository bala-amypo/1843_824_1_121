package com.example.demo.service;

import com.example.demo.model.Student;
import java.util.List;

public interface UserService {
    User addStudent(Student student);
    List<student> getAllStudents();
}
