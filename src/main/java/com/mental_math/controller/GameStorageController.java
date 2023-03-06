package com.mental_math.controller;

import com.mental_math.model.domain.Game;
import com.mental_math.service.GameStorageService;
import com.mental_math.service.auth.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/games")
@RestController
@AllArgsConstructor
public class GameStorageController {
    private final GameStorageService gameStorageService;
    private final JwtService jwtService;

    @PostMapping("/save")
    public boolean saveGame(
            @RequestHeader(name="Authorization")
            String token,
            @RequestBody
            Game game) {
        String username = jwtService.extractUsername(token);
        gameStorageService.storeGame(username, game);
        return true;
    }

    @GetMapping("/get/all")
    public List<Game> getAllGames(
            @RequestHeader(name="Authorization")
            String token
    ) {
        String username = jwtService.extractUsername(token);
        return gameStorageService.getGames(username);
    }
}
