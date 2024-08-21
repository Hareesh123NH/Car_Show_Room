package com.carShowRoom.CarShowRoom.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RentalCars {

    @Id
    private int id;
    private String name;
    private String company;
    private String model;
    private String color;
    private double price;

    public RentalCars() {
        super();
    }

    public RentalCars(int id, String name, String company, String model, String color, double price) {
        super();
        this.id = id;
        this.name = name;
        this.company = company;
        this.model = model;
        this.color = color;
        this.price = price;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

