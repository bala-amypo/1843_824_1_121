package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@Entity
@Table(name = "exam_room")
public class ExamRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", unique = true, nullable = false)
    private String roomNumber;

    private Integer capacity;

    @Column(name = "no_of_rows")
    private Integer rows;

    @Column(name = "no_of_columns")
    private Integer columns;

    public ExamRoom() {
    }
    @PrePersist
    @PreUpdate
    private void calculateCapacity() {
        if (rows != null && columns != null) {
            this.capacity = rows * columns;
        }
    }
    public ExamRoom(String roomNumber, Integer capacity, Integer rows, Integer columns) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.rows = rows;
        this.columns = columns;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }
}
