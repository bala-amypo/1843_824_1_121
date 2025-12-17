package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy=GeneratedType.Identity)
    private int id;
    
    private String name;
    @Column(unique=true)
    private String email;
    
    private String password;

}