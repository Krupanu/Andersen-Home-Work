package com.example.andersenhomework.controller;

import com.example.andersenhomework.exceptions.ResourceNotFoundException;
import com.example.andersenhomework.models.Customer;
import com.example.andersenhomework.models.Space;
import com.example.andersenhomework.repository.CustomerRepository;
import com.example.andersenhomework.repository.SpaceRepository;
import com.example.andersenhomework.utils.ValidationUtils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AdminMenuController {
    SpaceRepository spaceRepository = SpaceRepository.getInstance();
    CustomerRepository customerRepository = CustomerRepository.getInstance();
    private static final AtomicInteger counterForCustomers = new AtomicInteger(1);

    private static final AtomicInteger counterForSpaces = new AtomicInteger(1);


    public AdminMenuController() {
    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the customer:");
        String name = scanner.nextLine();
        ValidationUtils.validateCustomerName(name);
        int id = counterForCustomers.getAndIncrement();
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
        Optional<Customer> customer = customerRepository.getCustomers().stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if (customer.isPresent()) {
            System.out.println("Customer Id: " + customer.get().getId());
            System.out.println("Customer Name: " + customer.get().getName());
        } else {
            System.out.println("Customer not found!");
        }
    }

    public void viewAllCustomers() {
        long customerCount = customerRepository.getCustomers().stream().count();

        if (customerCount == 0) {
            System.out.println("No customers found!");
        } else {
            System.out.println("Number of customers: " + customerCount);
            customerRepository.getCustomers().forEach(customer -> {
                System.out.println("Customer Id: " + customer.getId());
                System.out.println("Customer Name: " + customer.getName());
            });
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
        int id = counterForSpaces.getAndIncrement();
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
        long availableSpacesCount = spaceRepository.getSpaces().stream()
                .filter(Space::getSpaceAvailability)
                .count();

        if (availableSpacesCount == 0) {
            System.out.println("No work spaces found!");
        } else {
            System.out.println("Number of available work spaces: " + availableSpacesCount);
            for (Space space : spaceRepository.getSpaces()) {
                if (space.getSpaceAvailability()) {
                    System.out.println("Space Id: " + space.getId());
                    System.out.println("Space Type: " + space.getSpaceType());
                    System.out.println("Space Description: " + space.getDescription());
                    System.out.println("Space Price: " + space.getPrice());
                    System.out.println("Space Availability: " + space.getSpaceAvailability());
                }
            }
        }
    }
    public void clearCustomers() {
        customerRepository.clearCustomers();
    }
}