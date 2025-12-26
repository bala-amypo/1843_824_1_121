package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.PrePersist;


@Entity
@Table(name = "seating_plan")
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime generatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "exam_session_id")
    private ExamSession examSession;

    @ManyToOne(optional = false)
    @JoinColumn(name = "exam_room_id")
    private ExamRoom room;

    @ManyToMany
    @JoinTable(
        name = "seating_plan_students",
        joinColumns = @JoinColumn(name = "seating_plan_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    // ✅ Added for test cases
    @Column(columnDefinition = "TEXT")
    private String arrangementJson;

    public SeatingPlan() {}

    public SeatingPlan(ExamSession examSession, ExamRoom room, List<Student> students, String arrangementJson) {
        this.examSession = examSession;
        this.room = room;
        this.students = students;
        this.arrangementJson = arrangementJson;
        this.generatedAt = LocalDateTime.now();
    }

    @PrePersist
    public void onCreate() {
        if (this.generatedAt == null) {
            this.generatedAt = LocalDateTime.now();
        }
    }

    // ---------- Getters & Setters ----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }

    public ExamSession getExamSession() { return examSession; }
    public void setExamSession(ExamSession examSession) { this.examSession = examSession; }

    public ExamRoom getRoom() { return room; }
    public void setRoom(ExamRoom room) { this.room = room; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public String getArrangementJson() { return arrangementJson; }
    public void setArrangementJson(String arrangementJson) { this.arrangementJson = arrangementJson; }
}
