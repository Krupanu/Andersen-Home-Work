package com.example.andersenHomeWork.abstractions;

import com.example.andersenHomeWork.dto.SpaceDto;
import com.example.andersenHomeWork.models.Space;

import java.util.List;

public interface SpaceService {
    void saveSpace(SpaceDto spaceDto);

    List<Space> findAllSpaces();

    Space findById(Long id);

    void softDeleteSpace(Long id);

    void addSpace(Space space);
}
