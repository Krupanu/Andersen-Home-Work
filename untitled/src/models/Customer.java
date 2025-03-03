package models;

public class Customer extends User {
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.role = "Customer";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(int id) {
        this.name = name;
    }

}

