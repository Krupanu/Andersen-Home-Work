package com.example.andersenHomeWork.utils;

public class ValidationUtils {

    public static void validateCustomerId(int customerId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be a positive integer.");
        }
    }

    public static void validateSpaceId(int spaceId) {
        if (spaceId <= 0) {
            throw new IllegalArgumentException("Space ID must be a positive integer.");
        }
    }

    public static void validateReservationId(int reservationId) {
        if (reservationId <= 0) {
            throw new IllegalArgumentException("Reservation ID must be a positive integer.");
        }
    }

    public static void validateCustomerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
    }

    public static void validateSpaceType(String spaceType) {
        if (spaceType == null || spaceType.trim().isEmpty()) {
            throw new IllegalArgumentException("Space type cannot be null or empty.");
        }
    }

    public static void validateSpaceDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Space description cannot be null or empty.");
        }
    }

    public static void validateSpacePrice(Double price) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Space price must be a positive number.");
        }
    }
}