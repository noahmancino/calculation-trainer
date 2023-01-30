package com.mental_math.controller;

import com.mental_math.model.domain.AuthenticationResponse;
import com.mental_math.service.AuthenticationService;
import com.mental_math.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestHeader
            @Pattern(
                    regexp = Constants.USERNAME_PATTERN,
                    message = "Invalid username"
            )
            String username,
            @RequestHeader
            @Pattern(
                    regexp = Constants.PASSWORD_PATTERN,
                    message = "Invalid password"
            )
            String password
    ) {
        return ResponseEntity.ok(authenticationService.register(username, password));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestHeader
            @Pattern(
                    regexp = Constants.USERNAME_PATTERN,
                    message = "Invalid username"
            )
            String username,
            @RequestHeader
            @Pattern(
                    regexp = Constants.PASSWORD_PATTERN,
                    message = "Invalid password"
            )
            String password
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(username, password));
    }
}
