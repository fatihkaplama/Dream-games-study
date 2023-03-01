package com.fatikaplama.dreamgames.study.controller;

import com.fatikaplama.dreamgames.study.model.Team;
import com.fatikaplama.dreamgames.study.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/users/{id}/teams")
    public ResponseEntity<Team> createTeam(@PathVariable Long id, @RequestBody Team team){
        return new ResponseEntity<>(teamService.createTeam(id, team), HttpStatus.CREATED);
    }

}
