package com.example.schoolproject.controller;

import com.example.schoolproject.model.dto.UserDto;
import com.example.schoolproject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AuthorizationController {
    private final AuthService authService;

    @Autowired
    public AuthorizationController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping()
    public UserDto getUserByNameAndPassword(@RequestParam String userName,
                                            @RequestParam String password) {
        return authService.authorize(userName, password);
    }
}
