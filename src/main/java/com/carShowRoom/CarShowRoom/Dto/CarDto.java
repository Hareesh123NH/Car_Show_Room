package com.carShowRoom.CarShowRoom.Dto;

public class CarDto {

    private int id;
    private String name;
    private String company;
    private String model;
    private String color;
    private double price;
    private long userId;

    public CarDto(int id, String name, String company, String model, String color, double price, int userId) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.model = model;
        this.color = color;
        this.price = price;
        this.userId = userId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }
}
