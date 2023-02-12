package com.mental_math.controller;

import com.mental_math.service.GameStorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/games")
@RestController
@AllArgsConstructor
public class GameStorageController {
    private final GameStorageService gameStorageService;

    @PostMapping("/save")
}
