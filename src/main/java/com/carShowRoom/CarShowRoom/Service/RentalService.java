package com.carShowRoom.CarShowRoom.Service;

import com.carShowRoom.CarShowRoom.Dto.CarDto;
import com.carShowRoom.CarShowRoom.Entity.RentalCars;
import com.carShowRoom.CarShowRoom.Repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {


    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CarService carService;

    public void saveRental(RentalCars rentalCars) {
        rentalRepository.save(rentalCars);
    }

    public List<RentalCars> findByUserId(long userId) {
        return rentalRepository.findByUserId(userId);
    }

    public List<RentalCars> findByUserIdAndNameContainingIgnoreCase(Long id,String search){
        return rentalRepository.findByUserIdAndNameContainingIgnoreCase(id,search);
    }

    public void deleteById(int id) {
        rentalRepository.deleteById(id);
    }
}
