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

    private Integer capacity;
    private Integer rows;
    private Integer columns;
    
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

    public ExamRoom(Long id,String roomNumber,Integer capacity,Integer rows,Integer columns){
         this.id=id;
         this.roomNumber=roomNumber;
         this.capacity=capacity;
         this.rows=rows;
         this.columns=columns;

    }
    public ExamRoom(){}
}