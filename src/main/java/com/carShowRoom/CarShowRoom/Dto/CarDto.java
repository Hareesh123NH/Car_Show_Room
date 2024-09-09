package com.carShowRoom.CarShowRoom.Dto;

import org.springframework.web.multipart.MultipartFile;

public class CarDto {

    private Integer id;
    private String name;
    private String company;
    private String model;
    private String color;
    private double price;

    private MultipartFile profileImage;

    public CarDto(Integer id, String name, String company, String model, String color, double price) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.model = model;
        this.color = color;
        this.price = price;
        //this.profileImage = profileImage;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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


    public MultipartFile getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(MultipartFile profileImage) {
        this.profileImage = profileImage;
    }
    
}
