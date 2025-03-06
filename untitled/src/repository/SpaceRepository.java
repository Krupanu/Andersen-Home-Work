package repository;

import exceptions.ResourceNotFoundException;
import models.Space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpaceRepository {
    private static SpaceRepository instance;
    private final List<Space> spaces;

    private SpaceRepository() {
        this.spaces = new ArrayList<>();
    }

    public static SpaceRepository getInstance() {
        if (instance == null) {
            instance = new SpaceRepository();
        }
        return instance;
    }

    public void addSpace(Space space) {
        spaces.add(space);
    }

    public List<Space> getSpaces() {
        return Collections.unmodifiableList(spaces);
    }

    public void removeSpace(int spaceId) {
        boolean removed = spaces.removeIf(space -> space.getId() == spaceId);
        if (!removed) {
            throw new ResourceNotFoundException("Space with id " + spaceId + " not found.");
        }
    }

    public void updateSpaceAvailability(int spaceId, boolean availability) {
        boolean updated = false;
        for (Space space : spaces) {
            if (space.getId() == spaceId) {
                space.setSpaceAvailability(availability);
                updated = true;
                break;
            }
        }
        if (!updated) {
            throw new ResourceNotFoundException("Space with id " + spaceId + " not found.");
        }
    }
}