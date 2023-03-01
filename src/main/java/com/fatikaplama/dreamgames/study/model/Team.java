package com.fatikaplama.dreamgames.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "capacity")
    private int capacity = 20;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_t_id", referencedColumnName = "t_id")
    private List<User> users;

    public Team(){
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        Boolean exists = getUsers().contains(user);
        if(!exists){
            setCapacity(getCapacity() - 1);
            this.users.add(user);
        }
    }
}
