package com.carShowRoom.CarShowRoom.Repository;

import com.carShowRoom.CarShowRoom.Entity.RentalCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalCars, Integer> {

    List<RentalCars> findByUserId(long id);
}
