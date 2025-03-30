package com.example.andersenhomework.state;

import com.example.andersenhomework.models.Reservation;
import com.example.andersenhomework.models.Space;
import com.example.andersenhomework.repository.CustomerRepository;
import com.example.andersenhomework.repository.ReservationRepository;
import com.example.andersenhomework.repository.SpaceRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StateSaver {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void saveSpaceStatus(List<T> list, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }


    public static <T> void saveReservationStatus(List<T> list, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }

    public static <T> void saveCustomerStatus(List<T> list, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }
}