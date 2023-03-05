package com.fatikaplama.dreamgames.study.repository;

import com.fatikaplama.dreamgames.study.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByCapacityGreaterThan(int capacity);
    Boolean existsByName(String name);
    Team findByName(String name);
}
