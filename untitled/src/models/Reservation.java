package models;

public class Reservation {
    private int id;
    private int customerId;
    private int spaceId;

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