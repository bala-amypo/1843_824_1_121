package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
}