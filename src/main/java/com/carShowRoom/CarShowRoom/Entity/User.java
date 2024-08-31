package com.carShowRoom.CarShowRoom.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Car> cars;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RentalCars> rentalCars;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    private String address;

    @Lob
    private byte[] image;

    public User(long id, String username, String password, List<Car> cars, List<RentalCars> rentalCars, String email, String phone, String address, byte[] image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cars = cars;
        this.rentalCars = rentalCars;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
    }

    public User() {
        super();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<RentalCars> getRentalCars() {
        return rentalCars;
    }

    public void setRentalCars(List<RentalCars> rentalCars) {
        this.rentalCars = rentalCars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
