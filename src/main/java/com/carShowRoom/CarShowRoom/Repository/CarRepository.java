package com.carShowRoom.CarShowRoom.Repository;

import com.carShowRoom.CarShowRoom.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CarRepository extends JpaRepository<Car,Integer> {

}
