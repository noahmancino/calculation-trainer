package com.mental_math.service;

import com.mental_math.model.domain.Game;
import com.mental_math.model.domain.User;
import com.mental_math.repository.UserDAO;
import com.mental_math.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameStorageService {
    private final UserDAO userDAO;
    private final UserRepository userRepository;

    /**
     * Stores game and associates it with username
     * @param username name of user who played the game
     * @param game game to be saved
     */
    public void storeGame(String username, Game game) {
        userDAO.saveGame(username, game);
    }

    /**
     * Retreives all games associated with user
     * @param username name of user
     * @return list of all past games played by user
     */
    public List<Game> getGames(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No games for this user");
        return user.get().getGames();
    }
}
