// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Table;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.PreUpdate;

// import lombok.Getter;
// import lombok.Setter;
// import lombok.Builder;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Entity
// @Table(name = "exam_room")
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class ExamRoom {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "room_number", unique = true, nullable = false)
//     private String roomNumber;

//     private Integer capacity;

//     @Column(name = "no_of_rows")
//     private Integer rows;

//     @Column(name = "no_of_columns")
//     private Integer columns;

//     // ✅ Custom constructor (useful for manual creation)
//     public ExamRoom(String roomNumber, Integer rows, Integer columns) {
//         this.roomNumber = roomNumber;
//         this.rows = rows;
//         this.columns = columns;
//     }

//     // ✅ Auto-calculate capacity before save/update
//     @PrePersist
//     @PreUpdate
//     private void calculateCapacity() {
//         if (rows != null && columns != null) {
//             this.capacity = rows * columns;
//         }
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "exam_rooms", uniqueConstraints = {@UniqueConstraint(columnNames = "roomNumber")})
public class ExamRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String RoomNumber;

    private Integer rows;
    private Integer columns;
    private Integer capacity;

    public void ensureCapacityMatches() {
        if (rows != null && columns != null) {
            this.capacity = rows * columns;
        }
    }
}
