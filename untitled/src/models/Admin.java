package models;

public class Admin extends User {
    public Admin(int id, String name) {
        this.id = id;
        this.name = name;
        this.role = "Admin";
    }
}

