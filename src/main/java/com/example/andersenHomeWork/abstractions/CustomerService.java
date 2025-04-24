package com.example.andersenHomeWork.abstractions;

import com.example.andersenHomeWork.dto.ReservationDto;

public interface CustomerService {
    void addReservation(Long userId, Long spaceId);
    void deleteReservation(Long spaceId,Long userId);
}
