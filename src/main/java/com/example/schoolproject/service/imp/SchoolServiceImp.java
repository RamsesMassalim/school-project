package com.example.schoolproject.service.imp;

import com.example.schoolproject.entity.User;
import com.example.schoolproject.mapper.UserMapper;
import com.example.schoolproject.model.dto.UserDto;
import com.example.schoolproject.model.exception.UserNotFoundException;
import com.example.schoolproject.model.request.UserRequest;
import com.example.schoolproject.service.SchoolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImp implements SchoolService {
    private final ModelMapper modelMapper;
    private final UserMapper userMapper;

    @Autowired
    public SchoolServiceImp(UserMapper userMapper, ModelMapper modelMapper) {
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addUser(UserRequest userRequest) {
        User mappedUser = modelMapper.map(userRequest, User.class);

        userMapper.addUser(mappedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userMapper.getAll();

        return mapUserListToUserDTOList(users);
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userMapper.getUserById(id);

        if (user == null) {
            throw new UserNotFoundException("User with id:" + id + " is not registered.");
        }

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userMapper.getUserById(id);

        if (user == null) {
            throw new UserNotFoundException("User with id:" + id + " is not registered.");
        }

        userMapper.deleteUserById(id);
    }

    private List<UserDto> mapUserListToUserDTOList(List<User> users) {
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
}
