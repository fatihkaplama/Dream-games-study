package com.fatikaplama.dreamgames.study.repository;

import com.fatikaplama.dreamgames.study.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
