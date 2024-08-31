package com.carShowRoom.CarShowRoom.Dto;

import org.springframework.web.multipart.MultipartFile;

public class UserRegisterationDto {

    private long id;
    private String userName;
    private String password;

    private String email;
    private String phone;
    private String address;
    private MultipartFile profileImage;

    public UserRegisterationDto(String userName, String password, String email, String phone, String address, MultipartFile profileImage) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.profileImage = profileImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRegisterationDto() {
        super();
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public MultipartFile getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(MultipartFile profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "UserRegisterationDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
