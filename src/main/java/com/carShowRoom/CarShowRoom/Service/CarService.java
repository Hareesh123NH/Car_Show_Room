package com.carShowRoom.CarShowRoom.Service;

import com.carShowRoom.CarShowRoom.Dto.CarDto;
import com.carShowRoom.CarShowRoom.Entity.Car;
import com.carShowRoom.CarShowRoom.Entity.User;
import com.carShowRoom.CarShowRoom.Repository.CarRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> findByUserId(long userId) {
        return carRepository.findByUserId(userId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public CarDto convertToDto(Car car) {
        return new CarDto(
                car.getId(), car.getName(), car.getCompany(), car.getColor(), car.getModel(), car.getPrice(), (int) car.getUser().getId()
        );
    }


    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public Car getCarById(int id) {
        return carRepository.getReferenceById(id);
    }

    public void deleteById(int id) {
        carRepository.deleteById(id);
    }
}
