package com.example.andersenHomeWork.controller;

import com.example.andersenHomeWork.abstractions.abstractionImpl.CustomerServiceImpl;
import com.example.andersenHomeWork.dto.ReservationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerMenuController {

    private CustomerServiceImpl customerService;

    public CustomerMenuController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addReservation")
    public ResponseEntity<?> addReservation(@RequestBody ReservationDto request) {
        customerService.addReservation(request.getUserId(), request.getSpaceId());
        return ResponseEntity.ok("Reservation added successfully");
    }

    @PostMapping("/deleteReservation/{spaceId}/{userId}")
    public ResponseEntity<?> deleteReservation(@PathVariable("spaceId") Long spaceId,@PathVariable("userId") Long userId) {
        customerService.deleteReservation(spaceId,userId);
        return ResponseEntity.ok("Reservation deleted successfully");
    }
}