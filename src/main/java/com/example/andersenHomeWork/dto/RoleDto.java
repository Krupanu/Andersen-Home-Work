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
public class RoleDto {
    private Role value;

    private String title;
}