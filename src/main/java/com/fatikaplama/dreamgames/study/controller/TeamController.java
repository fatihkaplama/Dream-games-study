package com.fatikaplama.dreamgames.study.controller;

import com.fatikaplama.dreamgames.study.model.Team;
import com.fatikaplama.dreamgames.study.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/teams/{teamId}/users/{userId}")
    public ResponseEntity<Team> joinTeam(@PathVariable Long teamId, @PathVariable Long userId){
        return new ResponseEntity<>(teamService.joinTeam(userId, teamId), HttpStatus.OK);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getRandomTenTeams(){
        return new ResponseEntity<>(teamService.getRandomTenTeamsWithEmptyPlace(), HttpStatus.OK);
    }
}
