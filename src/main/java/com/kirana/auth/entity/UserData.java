package com.kirana.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user_data", indexes = {@Index(name = "idx_name", columnList = "name", unique = true)})
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    public UserData() {

    }

}
