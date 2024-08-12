package org.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberClass;
    private int numberSchool;
    private List<Integer> estimations;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public Diary(int numberClass, int numberSchool, List<Integer> estimations) {
        this.numberClass = numberClass;
        this.numberSchool = numberSchool;
        this.estimations = estimations;
    }
}
