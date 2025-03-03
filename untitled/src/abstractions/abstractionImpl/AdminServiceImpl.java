package abstractions.abstractionImpl;

import models.Customer;
import models.Space;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl {
    private final List<Customer> customers = new ArrayList<>();
    private final List<Space> spaces = new ArrayList<>();
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(int userId) {
        customers.removeIf(customer -> customer.getId() == userId);
    }

    public Customer getCustomerById(int userId) {
        for (Customer customer : customers) {
            if (customer.getId() == userId) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
    public void addWorkSpace(Space space) {
        spaces.add(space);
    }

    public void removeWorkSpace(int spaceId) {
        spaces.removeIf(space -> space.getId() == spaceId);
    }

    public void viewAllReservations() {
        for (Space space : spaces) {
            if (space.getSpaceAvailability() == false){
            System.out.println("Space Id: " + space.getId());
            System.out.println("Space Type: " + space.getSpaceType());
            System.out.println("Space Description: " + space.getDescription());
            System.out.println("Space Price: " + space.getPrice());
            System.out.println("Space Availability: " + space.getSpaceAvailability());
            }
            else System.out.println("No reservations!");
        }
    }

    public List<Space> getAllWorkSpaces() {
        return spaces;
    }
}
