package com.example.andersenHomeWork.abstractions.abstractionImpl;

import com.example.andersenHomeWork.abstractions.SpaceService;
import com.example.andersenHomeWork.dto.SpaceDto;
import com.example.andersenHomeWork.models.Space;
import com.example.andersenHomeWork.repository.SpaceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceServiceImpl implements SpaceService {

    SpaceRepository spaceRepository;
    Space space;

    public SpaceServiceImpl(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    @Override
    public void saveSpace(SpaceDto spaceDto) {
        Space space = new Space();
        space.setDescription(spaceDto.getDescription());
        space.setPrice(spaceDto.getPrice());
        space.setSpaceType(spaceDto.getSpaceType());
        space.setSpaceAvailability(spaceDto.getSpaceAvailability());
        spaceRepository.save(space);
    }

    @Override
    public void addSpace(Space space) {
        spaceRepository.save(space);
    }

    @Override
    public List<Space> findAllSpaces() {
        return spaceRepository.findAllByDeletedFalse();
    }

    @Override
    public Space findById(Long id) {
        return spaceRepository.getSpaceById(id);
    }

    @Override
    public void softDeleteSpace(Long id) {
        Optional<Space> optionalSpace = spaceRepository.findByIdAndDeletedFalse(id);
        if (optionalSpace.isPresent()) {
            Space space = optionalSpace.get();
            space.setDeleted(true);
            spaceRepository.save(space);
        } else {
            throw new EntityNotFoundException("Space not found or already deleted");
        }
    }
}
