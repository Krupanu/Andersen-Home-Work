package controller;

import exceptions.ResourceNotFoundException;
import models.Customer;
import models.Space;
import repository.CustomerRepository;
import repository.SpaceRepository;
import utils.ValidationUtils;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AdminMenuController {
    SpaceRepository spaceRepository = SpaceRepository.getInstance();
    private static final AtomicInteger counter = new AtomicInteger(1);
    CustomerRepository customerRepository = CustomerRepository.getInstance();

    public AdminMenuController() {
    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the customer:");
        String name = scanner.nextLine();
        ValidationUtils.validateCustomerName(name);
        int id = counter.getAndIncrement();
        customerRepository.addCustomer(new Customer(id, name));
    }

    public void removeCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the customer you want to remove:");
        int id = scanner.nextInt();
        ValidationUtils.validateCustomerId(id);
        customerRepository.removeCustomer(id);
    }

    public void viewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the customer you want to view:");
        int id = scanner.nextInt();
        ValidationUtils.validateCustomerId(id);
        for (Customer customer : customerRepository.getCustomers()) {
            if (customer.getId() == id) {
                System.out.println("Customer Id: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
            } else {
                System.out.println("Customer not found!");
            }
        }
    }

    public void viewAllCustomers() {
        for (Customer customer : customerRepository.getCustomers()) {
            if (customer == null) {
                System.out.println("No customers found!");
                break;
            } else {
                System.out.println("Customer Id: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
            }
        }
    }

    public void addWorkSpace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of the space:");
        String spaceType = scanner.nextLine();
        ValidationUtils.validateSpaceType(spaceType);
        System.out.println("Enter the description of the space:");
        String description = scanner.nextLine();
        ValidationUtils.validateSpaceDescription(description);
        System.out.println("Enter the price of the space:");
        Double price = scanner.nextDouble();
        ValidationUtils.validateSpacePrice(price);
        int id = counter.getAndIncrement();
        spaceRepository.addSpace(new Space(id, spaceType, description, price, true));
    }

    public void removeWorkSpace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the space you want to remove:");
        int id = scanner.nextInt();
        ValidationUtils.validateSpaceId(id);
        try {
            spaceRepository.removeSpace(id);
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewAllWorkSpaces() {
        for (Space space : spaceRepository.getSpaces()) {
            if (space == null) {
                System.out.println("No work spaces found!");
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
}