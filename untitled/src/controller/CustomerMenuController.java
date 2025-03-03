package controller;

import abstractions.abstractionImpl.AdminServiceImpl;
import abstractions.abstractionImpl.CustomerServiceImpl;
import models.Reservation;
import models.Space;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerMenuController {
    CustomerServiceImpl customerServiceImpl;
    AdminServiceImpl adminServiceImpl;

    private static final AtomicInteger counter = new AtomicInteger(1);

    public void makeReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the customer id:");
        int customerId = scanner.nextInt();
        System.out.println("Enter the space id:");
        int spaceId = scanner.nextInt();
        int id = counter.getAndIncrement();
        Reservation reservation = new Reservation(id, customerId, spaceId);
        customerServiceImpl.setReservationStatus(spaceId);
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the reservation id:");
        int reservationId = scanner.nextInt();
        customerServiceImpl.cancelReservation(reservationId);
    }

    public void viewWorkSpace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the space id:");
        int spaceId = scanner.nextInt();
        Space space = customerServiceImpl.getWorkSpaceById(spaceId);
        if (space != null) {
            System.out.println("Space Id: " + space.getId());
            System.out.println("Space Type: " + space.getSpaceType());
            System.out.println("Space Description: " + space.getDescription());
            System.out.println("Space Price: " + space.getPrice());
            System.out.println("Space Availability: " + space.getSpaceAvailability());
        } else {
            System.out.println("Space not found!");
        }
    }

    public void viewAllReservations() {
        for (Reservation reservation : customerServiceImpl.getAllReservations()) {
            if (reservation == null) {
                System.out.println("No reservations found!");
                break;
            }
            else {
                System.out.println("Reservation Id: " + reservation.getId());
                System.out.println("Customer Id: " + reservation.getCustomerId());
                System.out.println("Space Id: " + reservation.getSpaceId());
            }
        }
    }

    public void viewAllWorkSpaces() {
        for (Space space : customerServiceImpl.getAllWorkSpaces()) {
            if (space == null) {
                System.out.println("No work spaces found!");
                break;
            }
            else {
                System.out.println("Space Id: " + space.getId());
                System.out.println("Space Type: " + space.getSpaceType());
                System.out.println("Space Description: " + space.getDescription());
                System.out.println("Space Price: " + space.getPrice());
                System.out.println("Space Availability: " + space.getSpaceAvailability());
            }
        }
    }
}
