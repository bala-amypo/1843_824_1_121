// package com.example.demo.model;

// import java.time.LocalDateTime;
// import java.util.List;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;

// @Entity
// public class SeatingPlan {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private LocalDateTime generatedAt;

//     @ManyToMany
//     private List<Student> students;

//     // ✅ REQUIRED DEFAULT CONSTRUCTOR
//     public SeatingPlan() {
//     }

//     // ✅ OPTIONAL PARAMETERIZED CONSTRUCTOR
//     public SeatingPlan(LocalDateTime generatedAt, List<Student> students) {
//         this.generatedAt = generatedAt;
//         this.students = students;
//     }

//     // ---------- getters & setters ----------

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public LocalDateTime getGeneratedAt() {
//         return generatedAt;
//     }

//     public void setGeneratedAt(LocalDateTime generatedAt) {
//         this.generatedAt = generatedAt;
//     }

//     public List<Student> getStudents() {
//         return students;
//     }

//     public void setStudents(List<Student> students) {
//         this.students = students;
//     }
// }
package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime generatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "exam_session_id")
    private ExamSession examSession;

    @ManyToMany
    @JoinTable(
        name = "seating_plan_students",
        joinColumns = @JoinColumn(name = "seating_plan_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    // ✅ Default constructor (required by JPA)
    public SeatingPlan() {
    }

    // ✅ Parameterized constructor
    public SeatingPlan(LocalDateTime generatedAt,
                       ExamSession examSession,
                       List<Student> students) {
        this.generatedAt = generatedAt;
        this.examSession = examSession;
        this.students = students;
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public ExamSession getExamSession() {
        return examSession;
    }

    public void setExamSession(ExamSession examSession) {
        this.examSession = examSession;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
