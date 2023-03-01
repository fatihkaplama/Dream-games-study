package com.fatikaplama.dreamgames.study.service;

import com.fatikaplama.dreamgames.study.model.Team;
import com.fatikaplama.dreamgames.study.model.User;
import com.fatikaplama.dreamgames.study.repository.TeamRepository;
import com.fatikaplama.dreamgames.study.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{
    private UserRepository userRepository;
    private TeamRepository teamRepository;

    public TeamServiceImpl(UserRepository userRepository, TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createTeam(Long userId, Team team) {
        Boolean exists = teamRepository.existsByName(team.getName());
        if(exists){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Team with this name is already exist");
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }
        
        User user = userOptional.get();
        int userCoins = user.getCoins();

        if(userCoins < 1000){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Coins are not enough");
        }

        user.setCoins(userCoins - 1000);
        return teamRepository.save(team);
    }

    @Override
    public Team joinTeam(Long userId, Long teamId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Team not found"));

        if(team.getCapacity() == 0){
            throw new RuntimeException("This team's capacity is full");
        }

        team.addUser(user);
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getRandomTenTeamsWithEmptyPlace() {
        List<Team> teamsWithCapacityGreaterThanZero = teamRepository.findByCapacityGreaterThan(0);
        Collections.shuffle(teamsWithCapacityGreaterThanZero);
        List<Team> randomTeams = teamsWithCapacityGreaterThanZero.subList(0, 10);
        return randomTeams;
    }
}
