package com.example.schoolproject.service;

import com.example.schoolproject.model.dto.UserDto;

public interface AuthService {
    UserDto authorize(String name, String password);
}
