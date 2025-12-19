package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ExamSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;

    private LocalDate examDate;

    private String examTime;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // handles new/existing students
    @JoinTable(
        name = "exam_session_students",
        joinColumns = @JoinColumn(name = "exam_session_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    // Default constructor
    public ExamSession() {}

    // Constructor with all fields
    public ExamSession(Long id, String courseCode, LocalDate examDate, String examTime, List<Student> students) {
        this.id = id;
        this.courseCode = courseCode;
        this.examDate = examDate;
        this.examTime = examTime;
        this.students = students;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public LocalDate getExamDate() { return examDate; }
    public void setExamDate(LocalDate examDate) { this.examDate = examDate; }

    public String getExamTime() { return examTime; }
    public void setExamTime(String examTime) { this.examTime = examTime; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
