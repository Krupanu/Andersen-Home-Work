package abstractions.abstractionImpl;

import models.Customer;
import models.Reservation;
import models.Space;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl {
    private final List<Reservation> reservations = new ArrayList<>();
    private final List<Space> spaces;

    public CustomerServiceImpl(List<Space> spaces) {
        this.spaces = spaces;
    }

    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Space getWorkSpaceById(int spaceId) {
        for (Space space : spaces) {
            if (space.getId() == spaceId) {
                return space;
            }
        }
        return null;
    }

    public void cancelReservation(int reservationId) {
        reservations.removeIf(reservation -> reservation.getId() == reservationId);
    }

    public void setReservationStatus(int spaceId) {
        for (Space space : spaces) {
            if (space.getId() == spaceId) {
                space.setSpaceAvailability(false);
            }
        }
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public List<Space> getAllWorkSpaces() {
        return spaces;
    }
}
