package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String rollNumber;

    private String name;
    private String department;
    private Integer year;

    public Student() {}

    public Student(Long id, String rollNumber, String name, String department, Integer year) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;
        this.year = year;
    }
}
