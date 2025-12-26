package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "seating_plan")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Set<Student> students;

    @Column(columnDefinition = "TEXT")
    private String arrangementJson;

    @PrePersist
    private void onCreate() {
        if (generatedAt == null) {
            generatedAt = LocalDateTime.now();
        }
    }
}
