package com.example.andersenHomeWork.repository;

import com.example.andersenHomeWork.dto.SpaceDto;
import com.example.andersenHomeWork.models.Space;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpaceRepository extends JpaRepository <Space,Long>{
    Space getSpaceById(Long id);
    List<Space> findAllByDeletedFalse();
    Optional<Space> findByIdAndDeletedFalse(Long id);;
}