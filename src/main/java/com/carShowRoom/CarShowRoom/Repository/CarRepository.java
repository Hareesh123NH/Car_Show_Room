package com.carShowRoom.CarShowRoom.Repository;

import com.carShowRoom.CarShowRoom.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByUserId(long userId);
}
