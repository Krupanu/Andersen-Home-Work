package repository;

import exceptions.ResourceNotFoundException;
import models.Reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationRepository {
    private static ReservationRepository instance;
    private final List<Reservation> reservations;
    private static final AtomicInteger counter = new AtomicInteger(0);

    private ReservationRepository() {
        this.reservations = new ArrayList<>();
    }

    public static ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }

    public void setReservations(Reservation reservation) {
        reservations.add(reservation);
    }

    public void cancelReservation(int reservationId) {
        boolean removed = reservations.removeIf(reservation -> reservation.getId() == reservationId);
        if (!removed) {
            throw new ResourceNotFoundException("Reservation with id " + reservationId + " not found.");
        }
    }
}