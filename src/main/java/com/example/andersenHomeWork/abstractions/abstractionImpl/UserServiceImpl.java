package com.example.andersenHomeWork.abstractions.abstractionImpl;


import com.example.andersenHomeWork.dto.UserDto;
import com.example.andersenHomeWork.models.Role;
import com.example.andersenHomeWork.models.User;
import com.example.andersenHomeWork.repository.UserRepository;
import com.example.andersenHomeWork.abstractions.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDto> ConvertUserToCustomers(List<User> users, Role role) {
        return users.stream()
                .filter(user -> user.getRole().equals(Role.CUSTOMER))
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<UserDto> findAllCustomers() {
        return ConvertUserToCustomers(userRepository.findAll(), Role.CUSTOMER);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
