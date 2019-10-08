package ru.vtungusov.db.models;

public class Car {
    private int id;
    private String model;
    private User owner;


    public Car() {
    }

    public Car(int id, String model, User owner) {
        this.id = id;
        this.model = model;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
