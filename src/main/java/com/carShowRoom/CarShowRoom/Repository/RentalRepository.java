package com.carShowRoom.CarShowRoom.Repository;

import com.carShowRoom.CarShowRoom.Entity.RentalCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<RentalCars,Integer> {
}
