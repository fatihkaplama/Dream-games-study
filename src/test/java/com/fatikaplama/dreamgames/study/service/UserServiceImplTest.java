package com.fatikaplama.dreamgames.study.service;

import com.fatikaplama.dreamgames.study.model.User;
import com.fatikaplama.dreamgames.study.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceImplTest {
    UserRepository userRepository;
    UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = Mockito.mock(UserService.class);
    }

    @Test
    void create_shouldCreateUserSuccessfully(){
        // given
        User expected = new User(1, "fatih23", 5000, 1, false);

        Mockito.when(userRepository.save(any())).thenReturn(expected);

        // when
        User actual = userRepository.save(expected);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getId(), actual.getId())
        );
    }

    @Test
    void update_shouldUpdateUsersLevelSuccessfully(){
        // given
        User user = new User(1, "fatih23", 5000, 1, false);
        user.setLevel(user.getLevel() + 1);
        user.setCoins(user.getCoins() + 25);
        User expected = user;

        Mockito.when(userService.updateLevel(any())).thenReturn(expected);

        // when
        User actual = userService.updateLevel(user.getId());

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getId(), actual.getId())
        );
    }

}