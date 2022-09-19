package com.example.schoolproject.service.imp;

import com.example.schoolproject.entity.User;
import com.example.schoolproject.mapper.UserMapper;
import com.example.schoolproject.model.dto.UserDto;
import com.example.schoolproject.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
    private final ModelMapper modelMapper;
    private final UserMapper userMapper;

    @Autowired
    public AuthServiceImp(UserMapper userMapper, ModelMapper modelMapper) {
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto authorize(String userName, String password) {
        User user = userMapper.getUserByUserNameAndPassword(userName, password);

        if (user == null) {
            throw new RuntimeException("not found");
        }

        return modelMapper.map(user, UserDto.class);
    }
}
