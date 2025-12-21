package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class SeatingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ExamSession examSession;

    @ManyToOne
    private ExamRoom room;

    @Column(columnDefinition = "TEXT")
    private String arrangementJson;

    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public SeatingPlan() {}

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
