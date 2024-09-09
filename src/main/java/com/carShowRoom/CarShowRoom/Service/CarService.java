package com.carShowRoom.CarShowRoom.Service;

import com.carShowRoom.CarShowRoom.Dto.CarDto;
import com.carShowRoom.CarShowRoom.Dto.UserRegisterationDto;
import com.carShowRoom.CarShowRoom.Entity.Car;
import com.carShowRoom.CarShowRoom.Entity.User;
import com.carShowRoom.CarShowRoom.Repository.CarRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    //    public List<CarDto> findByUserIdAndCriteria(long id,String name,String company,String color){
//        return carRepository.findByUserIdAndCriteria(id, name, company, color)
//                .stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }


    public void saveCar(Car car) {

//        Car car = new Car();
//        car.setName(carDto.getName());
//        car.setCompany(carDto.getCompany());
//        car.setModel(carDto.getModel());
//        car.setUser(user);
//
//        MultipartFile profileImage = carDto.getProfileImage();
//        if (profileImage != null && !profileImage.isEmpty()) {
//            try {
//                car.setImage(profileImage.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//                // Handle the error appropriately
//            }
//        }
        carRepository.save(car);
    }

    public List<CarDto> findByUserIdAndNameContainingIgnoreCase(long id, String search) {
        return carRepository.findByUserIdAndNameContainingIgnoreCase(id, search)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CarDto> findByUserId(long userId) {
        return carRepository.findByUserId(userId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public CarDto convertToDto(Car car) {
        return new CarDto(
                car.getId(), car.getName(), car.getCompany(), car.getColor(), car.getModel(), car.getPrice()
        );
    }


//    public void saveCar(Car car) {
//        carRepository.save(car);
//    }

    public Car getCarById(int id) {
        return carRepository.getReferenceById(id);
    }

    public void deleteById(int id) {
        carRepository.deleteById(id);
    }

    public List<Car> getCarsStartWithA() {
        return carRepository.findByNameStartingWith("A");
    }
}
