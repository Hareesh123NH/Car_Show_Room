package com.carShowRoom.CarShowRoom.Service;

import com.carShowRoom.CarShowRoom.Entity.RentalCars;
import com.carShowRoom.CarShowRoom.Repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public void saveRental(RentalCars rentalCars){
        rentalRepository.save(rentalCars);
    }

    public List<RentalCars> getAllRentalCars(){
        return rentalRepository.findAll();
    }

    public void deleteById(int id){
        rentalRepository.deleteById(id);
    }
}
