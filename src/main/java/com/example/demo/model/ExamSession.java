package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

@Entity
public class ExamSession{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private LocalDate examDate;
    private String examTime;

    public Long getId() {
        return id;
    }

   
    public void setId(Long id) {
        this.id = id;
    }

   
    public String getCourseCode() {
        return courseCode;
    }

 
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    
    public LocalDate getExamDate() {
        return examDate;
    }

    
    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

   
    public String getExamTime() {
        return examTime;
    }

 
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public ExamSession(Long id,String courseCode,LocalDate examDate,String examTime){
    this.id=id;
    this.courseCode=courseCode;
    this.examDate=examDate;
    this.examTime=examTime;
    };
    public ExamSession(){};
}
