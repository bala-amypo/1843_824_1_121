package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many seating plans can belong to one exam session
    @ManyToOne
    @JoinColumn(name = "exam_session_id", nullable = false)
    private ExamSession examSession;

    // Many seating plans can use one exam room
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private ExamRoom room;

    // JSON string storing seat arrangement
    @Column(columnDefinition = "TEXT", nullable = false)
    private String arrangementJson;

    private LocalDateTime generatedAt;

    // 🔹 Default constructor (required by JPA)
    public SeatingPlan() {
    }

    // 🔹 Parameterized constructor
    public SeatingPlan(ExamSession examSession, ExamRoom room, String arrangementJson) {
        this.examSession = examSession;
        this.room = room;
        this.arrangementJson = arrangementJson;
    }

    // Auto-generate timestamp
    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    // Optional: capacity validation helper
    public boolean matchesRoomCapacity(int totalStudents) {
        return totalStudents <= room.getCapacity();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public ExamSession getExamSession() {
        return examSession;
    }

    public void setExamSession(ExamSession examSession) {
        this.examSession = examSession;
    }

    public ExamRoom getRoom() {
        return room;
    }

    public void setRoom(ExamRoom room) {
        this.room = room;
    }

    public String getArrangementJson() {
        return arrangementJson;
    }

    public void setArrangementJson(String arrangementJson) {
        this.arrangementJson = arrangementJson;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}
