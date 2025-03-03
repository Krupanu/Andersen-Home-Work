package controller;

import abstractions.abstractionImpl.AdminServiceImpl;
import models.Customer;
import models.Space;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AdminMenuController {
    private final AdminServiceImpl adminServiceImpl;
    public AdminMenuController() {
        adminServiceImpl = new AdminServiceImpl();
    }
    private static final AtomicInteger counter = new AtomicInteger(1);
    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the customer:");
        String name = scanner.nextLine();
        int id = counter.getAndIncrement();
        Customer customer = new Customer(id, name);
        adminServiceImpl.addCustomer(customer);
    }
    public void removeCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the customer you want to remove:");
        int id = scanner.nextInt();
        adminServiceImpl.removeCustomer(id);
    }
    public void viewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the customer you want to view:");
        int id = scanner.nextInt();
        Customer customer = adminServiceImpl.getCustomerById(id);
        if (customer != null) {
            System.out.println("Customer Id: " + customer.getId());
            System.out.println("Customer Name: " + customer.getName());
        } else {
            System.out.println("Customer not found!");
        }
    }

    public void viewAllCustomers() {

        for (Customer customer : adminServiceImpl.getAllCustomers()) {
            if (customer == null) {
                System.out.println("No customers found!");
                break;
            }
            else {
                System.out.println("Customer Id: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
            }
        }
    }

    public void addWorkSpace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of the space:");
        String spaceType = scanner.nextLine();
        System.out.println("Enter the description of the space:");
        String description = scanner.nextLine();
        System.out.println("Enter the price of the space:");
        Double price = scanner.nextDouble();
        System.out.println("Enter the availability of the space:");
        boolean spaceAvailability = scanner.nextBoolean();
        int Id = counter.getAndIncrement();
        Space space = new Space(Id, spaceType, description, price, spaceAvailability);
        adminServiceImpl.addWorkSpace(space);
    }

    public void removeWorkSpace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the space you want to remove:");
        int id = scanner.nextInt();
        adminServiceImpl.removeWorkSpace(id);
    }

    public void viewAllReservations() {
        adminServiceImpl.viewAllReservations();
    }

    public void viewAllWorkSpaces() {
        for (Space space : adminServiceImpl.getAllWorkSpaces()) {
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
