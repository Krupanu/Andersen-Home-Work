package com.example.andersenHomeWork.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SpaceAvailability {
    AVAILABLE("AVAILABLE"),
    UNAVAILABLE("UNAVAILABLE");

    private final String value;

    SpaceAvailability(final String value) {
        this.value = value;
    }

    @JsonCreator
    public static SpaceAvailability fromValue(String value) {
        for (SpaceAvailability spaceAvailability : SpaceAvailability.values()) {
            if (spaceAvailability.value.equalsIgnoreCase(value.trim())) {
                return spaceAvailability;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
