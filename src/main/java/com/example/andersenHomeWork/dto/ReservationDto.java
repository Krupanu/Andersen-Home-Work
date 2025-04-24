package com.example.andersenHomeWork.dto;

import com.example.andersenHomeWork.models.Role;
import com.example.andersenHomeWork.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long userId;

    private Long spaceId;
}
