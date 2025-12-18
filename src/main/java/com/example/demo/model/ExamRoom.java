package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class ExamRoom{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String roomNumber;

    private Long capacity;
    private Long rows;
    private Long columns;
    
     public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

   
    public String getRoomNumber() {
        return roomNumber;
    }

   
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

   
    public Long getCapacity() {
        return capacity;
    }


    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

   
    public Long getRows() {
        return rows;
    }

   
    public void setRows(Long rows) {
        this.rows = rows;
    }

   
    public Long getColumns() {
        return columns;
    }

  
    public void setColumns(Long columns) {
        this.columns = columns;
    }

    public ExamRoom(Long id,String roomNumber,Long capacity,Long rows,Long columns){
         this.id=id;
         this.roomNumber=roomNumber;
         this.capacity=capacity;
         this.rows=rows;
         this.columns=columns;

    }
    public ExamRoom(){}
}