package com.example.schoolproject.controller;

import com.example.schoolproject.model.dto.UserDto;
import com.example.schoolproject.model.request.UserRequest;
import com.example.schoolproject.service.SchoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@Validated @RequestBody UserRequest userRequest) {
        schoolService.addUser(userRequest);
    }

    @GetMapping()
    public List<UserDto> getUsers() {
        return schoolService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return schoolService.getUser(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable Long id) {
        schoolService.deleteUser(id);
    }
}
