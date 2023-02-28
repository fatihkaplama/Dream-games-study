package com.fatikaplama.dreamgames.study.repository;

import com.fatikaplama.dreamgames.study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
