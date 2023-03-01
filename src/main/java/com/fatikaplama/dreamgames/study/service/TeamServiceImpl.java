package com.fatikaplama.dreamgames.study.service;

import com.fatikaplama.dreamgames.study.model.Team;
import com.fatikaplama.dreamgames.study.model.User;
import com.fatikaplama.dreamgames.study.repository.TeamRepository;
import com.fatikaplama.dreamgames.study.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();
        int userCoins = user.getCoins();

        if(userCoins < 1000){
            throw new RuntimeException("Coins are not enough");
        }

        user.setCoins(userCoins - 1000);
        return teamRepository.save(team);
    }
}
