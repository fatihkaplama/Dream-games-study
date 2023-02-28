package com.fatikaplama.dreamgames.study.service;

import com.fatikaplama.dreamgames.study.model.User;

public interface UserService {
    User createUser(User user);
    User updateLevel(Long id);
}
