package com.example.andersenHomeWork.abstractions;

import com.example.andersenHomeWork.dto.UserDto;
import com.example.andersenHomeWork.models.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllCustomers();

    User findById(Long id);
}
