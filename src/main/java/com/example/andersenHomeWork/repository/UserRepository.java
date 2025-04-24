package com.example.andersenHomeWork.repository;


import com.example.andersenHomeWork.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllById(Long userId);
    Boolean existsByEmail(String email);
}
