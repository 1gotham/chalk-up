package com.chalkup.ChalkUp.controller;

import com.chalkup.ChalkUp.dto.auth.RegisterRequest;
import com.chalkup.ChalkUp.dto.auth.RegisterResponse;
import com.chalkup.ChalkUp.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest) {
        return userService.registerResponse(registerRequest);
    }
}

