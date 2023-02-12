package com.mental_math.service;

import com.mental_math.model.domain.Game;
import com.mental_math.repository.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameStorageService {
    private final UserDAO userDAO;

    /**
     * Stores game and associates it with username
     * @param username name of user who played the game
     * @param game the game
     */
    public void storeGame(String username, Game game) {
        userDAO.saveGame(username, game);
    }
}
