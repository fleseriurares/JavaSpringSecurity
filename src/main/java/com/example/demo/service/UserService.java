package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    boolean checkEmail(String email);

    UserDto registerUser(RegistrationRequest registrationRequest);

    UserDto getLoginUser();

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();
    List<User> findAll();

    UserDto createUser(User user);

    User updateUser(User user);



    void deleteUser(User user);

    void deleteUserById(Integer id);
}
