// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.Student;

// public interface StudentService {

//     Student saveStudent(Student student);

//     Student getByRollNumber(String rollNumber);

//     List<Student> getAllStudents();
// }
package com.example.demo.service;

import com.example.demo.model.Student;
import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
}
