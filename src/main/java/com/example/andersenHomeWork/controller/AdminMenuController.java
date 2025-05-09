package com.example.andersenHomeWork.controller;

import com.example.andersenHomeWork.abstractions.abstractionImpl.SpaceServiceImpl;
import com.example.andersenHomeWork.abstractions.abstractionImpl.UserServiceImpl;
import com.example.andersenHomeWork.dto.SpaceDto;
import com.example.andersenHomeWork.dto.UserDto;
import com.example.andersenHomeWork.models.Space;
import com.example.andersenHomeWork.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminMenuController{

    UserServiceImpl userService;
    SpaceServiceImpl spaceService;

    public AdminMenuController(UserServiceImpl userService,
                               SpaceServiceImpl spaceService) {
        this.userService = userService;
        this.spaceService = spaceService;
    }
    @GetMapping("/getAllCustomers")
    public List<UserDto>  getAllCustomers() {
        return userService.findAllCustomers();
    }

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<User> getCustomerById (@PathVariable ("customerId") Long customerId)
    {
        User user = userService.findById(customerId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getAllSpaces")
    public List<Space> getAllSpaces() {
        return spaceService.findAllSpaces();
    }

    @GetMapping("/getSpaceById/{spaceId}")
    public ResponseEntity<Space> getSpaceById(@PathVariable("spaceId") Long spaceId) {
        Space space = spaceService.findById(spaceId);
        if (space != null) {
            return ResponseEntity.ok(space);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addSpace")
    public ResponseEntity<String> addSpace(@RequestBody SpaceDto space) {
        spaceService.saveSpace(space);
        return ResponseEntity.ok("Space added successfully");
    }

    @DeleteMapping("/removeSpace/{spaceId}")
    public void removeSpace(@PathVariable("spaceId")Long spaceId){
        spaceService.softDeleteSpace(spaceId);
    }
}