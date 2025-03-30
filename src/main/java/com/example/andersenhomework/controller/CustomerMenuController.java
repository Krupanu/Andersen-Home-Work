package com.example.andersenhomework.controller;

import com.example.andersenhomework.exceptions.ResourceNotFoundException;
import com.example.andersenhomework.models.Reservation;
import com.example.andersenhomework.models.Space;
import com.example.andersenhomework.repository.ReservationRepository;
import com.example.andersenhomework.repository.SpaceRepository;
import com.example.andersenhomework.utils.ValidationUtils;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerMenuController {
    SpaceRepository spaceRepository = SpaceRepository.getInstance();
    ReservationRepository reservationRepository = ReservationRepository.getInstance();

    private static final AtomicInteger counterForReservation = new AtomicInteger(1);

    public CustomerMenuController() {
    }

    public void viewAllWorkSpaces() {
        for (Space space : spaceRepository.getSpaces()) {
            if (space == null) {
                System.out.println("No workspaces found!");
                break;
            } else {
                System.out.println("Space Id: " + space.getId());
                System.out.println("Space Type: " + space.getSpaceType());
                System.out.println("Space Description: " + space.getDescription());
                System.out.println("Space Price: " + space.getPrice());
                System.out.println("Space Availability: " + space.getSpaceAvailability());
            }
        }
    }

    public void makeReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the customer id:");
        int customerId = scanner.nextInt();
        ValidationUtils.validateCustomerId(customerId);
        System.out.println("Enter the space id:");
        int spaceId = scanner.nextInt();
        ValidationUtils.validateSpaceId(spaceId);
        int id = counterForReservation.getAndIncrement();
        reservationRepository.setReservations(new Reservation(id, customerId, spaceId));
        spaceRepository.updateSpaceAvailability(spaceId, false);
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the reservation id:");
        int reservationId = scanner.nextInt();
        ValidationUtils.validateReservationId(reservationId);
        try {
            reservationRepository.cancelReservation(reservationId);
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewAllReservations() {
        System.out.println("");
        for (Reservation reservation : reservationRepository.getReservations()) {
            if (reservation == null) {
                System.out.println("No reservations found!");
                break;
            }
            else {
                System.out.println("Reservation id:" + reservation.getId());
                System.out.println("Reservation customer id:" + reservation.getCustomerId());
                System.out.println("Reservation space id:" + reservation.getSpaceId());
                System.out.println("");
            }
        }
    }
}