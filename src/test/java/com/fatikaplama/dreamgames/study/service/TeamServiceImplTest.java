package com.fatikaplama.dreamgames.study.service;

import com.fatikaplama.dreamgames.study.model.Team;
import com.fatikaplama.dreamgames.study.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class TeamServiceImplTest {
    TeamService teamService;

    @BeforeEach
    void setUp() {
        teamService = Mockito.mock(TeamService.class);
    }

    @Test
    void create_shouldCreateTeamSuccessfully(){
        // given
        Team expected = new Team(1L, "Team 1", 20, new ArrayList<>());

        Mockito.when(teamService.createTeam(any(), any())).thenReturn(expected);

        // when
        Team actual = teamService.createTeam(1L, expected);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getId(), actual.getId())
        );
    }

    @Test
    void join_shouldJoinTheTeamSuccessfully(){
        // given
        User user = new User(1, "fatih", 5000, 1, false);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        Team expected = new Team(1L, "Team 1", 20, userList);

        Mockito.when(teamService.joinTeam(any(), any())).thenReturn(expected);

        // when
        Team actual = teamService.joinTeam(user.getId(), expected.getId());

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getId(), actual.getId())
        );
    }
}