package com.fatikaplama.dreamgames.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "coin")
    private int coins = 5000;

    @Column(name = "level")
    private int level = 1;

    @Column(name = "inTeam")
    private Boolean inTeam = false;
}
