package com.mental_math.controller;

import com.mental_math.model.domain.Game;
import com.mental_math.service.GameStorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/games")
@RestController
@AllArgsConstructor
public class GameStorageController {
    private final GameStorageService gameStorageService;

    // TODO: get username from JWT
    @PostMapping("/save")
    public boolean saveGame(
            @RequestHeader
            String username,
            @RequestBody
            Game game) {
        gameStorageService.storeGame(username, game);
        return true;
    }

    @GetMapping("/get/all")
    public List<Game> getAllGames(
            @RequestHeader
            String username
    ) {
        return gameStorageService.getGames(username);
    }
}
