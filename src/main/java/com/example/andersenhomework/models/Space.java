package com.example.andersenhomework.models;

public class Space {
    private int id;
    private String spaceType;
    private String description;
    private Double price;
    private boolean spaceAvailability;

    public Space(int id, String spaceType, String description, Double price, boolean spaceAvailability) {
        this.id = id;
        this.spaceType = spaceType;
        this.description = description;
        this.price = price;
        this.spaceAvailability = spaceAvailability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(int id) {
        this.spaceType = spaceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getSpaceAvailability() {
        return spaceAvailability;
    }

    public void setSpaceAvailability(boolean spaceAvailability) {
        this.spaceAvailability = spaceAvailability;
    }
}