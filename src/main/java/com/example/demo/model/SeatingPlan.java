package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class SeatingPlan{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String arrangementJson;
    private LocalDateTime generatedAt;

    public Long getId() {
        return id;
    }

   
    public void setId(Long id) {
        this.id = id;
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

   
    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public SeatingPlan(Long id,String arrangementJson,String generatedAt){
    this.id=id;
    this.arrangementJson=arrangementJson;
    this.generateAt=generateAt;
    };
    public SeatingPlan(){};
}

