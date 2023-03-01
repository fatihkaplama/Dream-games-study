package com.fatikaplama.dreamgames.study.service;

import com.fatikaplama.dreamgames.study.model.Team;

public interface TeamService {
    Team createTeam(Long userId, Team team);
    Team joinTeam(Long userId, Long teamId);
}
