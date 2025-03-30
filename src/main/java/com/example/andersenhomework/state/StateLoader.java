package com.example.andersenhomework.state;

import com.example.andersenhomework.models.Customer;
import com.example.andersenhomework.models.Reservation;
import com.example.andersenhomework.models.Space;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StateLoader {
    private static final Gson gson = new Gson();
    public static <T> List<T> loadSpaceStatus(String filePath, Type type) throws IOException {

        try (FileReader reader = new FileReader(filePath)) {

            return gson.fromJson(reader, type);
        }
    }

    public static <T> List<T> loadReservationStatus(String filePath, Type type) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        }
    }

    public static <T> List<T> loadCustomerStatus(String filePath, Type type) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        }
    }
}