package com.example.andersenHomeWork.dto;

import com.example.andersenHomeWork.models.SpaceAvailability;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpaceDto {
    private int id;
    @NotEmpty(message = "Enter space type")
    private String spaceType;
    @NotEmpty(message = "Description should not be empty")
    private String description;
    @NotEmpty(message = "Price should not be empty")
    private Double price;
    @NotEmpty(message = "Set space availability")
    private SpaceAvailability spaceAvailability;
}
