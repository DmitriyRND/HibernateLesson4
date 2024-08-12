package org.example.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private LocalDate dataLastEntry;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<SmartPhone> smartPhone;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Diary diary;

    public User(String login, String password, LocalDate dataLastEntry) {
        this.login = login;
        this.password = password;
        this.dataLastEntry = LocalDate.now();

    }
}
