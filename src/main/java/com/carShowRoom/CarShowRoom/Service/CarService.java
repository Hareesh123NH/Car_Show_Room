package com.carShowRoom.CarShowRoom.Service;

import com.carShowRoom.CarShowRoom.Entity.Car;
import com.carShowRoom.CarShowRoom.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void save(Car car){
        carRepository.save(car);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCarById(int id){
        return carRepository.findById(id).get();
    }

    public void deleteCarById(int id){
        carRepository.deleteById(id);
    }
}
