package com.example.andersenhomework.models;

public class Reservation {
    private final int id;
    private final int customerId;
    private final int spaceId;

    public Reservation(int id, int customerId, int spaceId) {
        this.id = id;
        this.customerId = customerId;
        this.spaceId = spaceId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getSpaceId() {
        return spaceId;
    }
}