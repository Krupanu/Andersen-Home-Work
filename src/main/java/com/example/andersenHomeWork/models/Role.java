package com.example.andersenHomeWork.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    private final String value;

    Role(final String value) {
        this.value = value;
    }

    @JsonCreator
    public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.value.equalsIgnoreCase(value.trim())) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}