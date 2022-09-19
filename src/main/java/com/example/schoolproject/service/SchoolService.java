package com.example.schoolproject.service;

import com.example.schoolproject.model.dto.UserDto;
import com.example.schoolproject.model.request.UserRequest;

import java.util.List;

public interface SchoolService {
    void addUser(UserRequest userRequest);

    List<UserDto> getAllUsers();

    UserDto getUser(Long id);

    void deleteUser(Long id);
}
