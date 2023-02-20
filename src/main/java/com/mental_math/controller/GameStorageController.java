package com.mental_math.controller;

import com.mental_math.model.domain.Game;
import com.mental_math.service.GameStorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/games")
@RestController
@AllArgsConstructor
public class GameStorageController {
    private final GameStorageService gameStorageService;

    @PostMapping("/save")
    public boolean saveGame(
            @RequestHeader
            String username,
            @RequestBody
            Game game) {
        gameStorageService.storeGame(username, game);
        return true;
    }
}
