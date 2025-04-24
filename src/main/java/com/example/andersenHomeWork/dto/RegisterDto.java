package com.example.andersenHomeWork.dto;

import com.example.andersenHomeWork.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
