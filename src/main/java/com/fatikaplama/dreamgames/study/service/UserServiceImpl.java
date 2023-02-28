package com.fatikaplama.dreamgames.study.service;

import com.fatikaplama.dreamgames.study.model.User;
import com.fatikaplama.dreamgames.study.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        String username = user.getUsername();
        User existingUser = userRepository.findByUsername(username);
        if(existingUser != null){
            throw new IllegalStateException("User with this username is already exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateLevel(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();
        user.setLevel(user.getLevel() + 1);
        user.setCoins(user.getCoins() + 25);
        return userRepository.save(user);
    }
}
