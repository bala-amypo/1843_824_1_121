
package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> list() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
