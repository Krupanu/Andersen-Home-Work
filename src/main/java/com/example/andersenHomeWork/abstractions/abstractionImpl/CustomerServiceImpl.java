package com.example.andersenHomeWork.abstractions.abstractionImpl;

import com.example.andersenHomeWork.abstractions.CustomerService;
import com.example.andersenHomeWork.dto.SpaceDto;
import com.example.andersenHomeWork.dto.UserDto;
import com.example.andersenHomeWork.models.Space;
import com.example.andersenHomeWork.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final SpaceServiceImpl spaceServiceImpl;
    private final UserServiceImpl userServiceImpl;

    public CustomerServiceImpl(SpaceServiceImpl spaceServiceImpl, UserServiceImpl userServiceImpl) {

        this.spaceServiceImpl = spaceServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void addReservation(Long userId, Long spaceId) {
        Space space = spaceServiceImpl.findById(spaceId);
        User user = userServiceImpl.findById(userId);

        space.getUsers().add(user);
        user.getUser_reservations().add(space);
        spaceServiceImpl.addSpace(space);
    }

    @Override
    public void deleteReservation(Long spaceId,Long userId) {
        Space space = spaceServiceImpl.findById(spaceId);
        User user = userServiceImpl.findById(userId);

        space.getUsers().remove(user);
        user.getUser_reservations().remove(space);
        spaceServiceImpl.addSpace(space);
    }
}
