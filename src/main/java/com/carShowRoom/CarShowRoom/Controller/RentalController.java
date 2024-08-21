package com.carShowRoom.CarShowRoom.Controller;

import com.carShowRoom.CarShowRoom.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @RequestMapping("/delete_rental/{id}")
    public String deleteById(@PathVariable int id){
        rentalService.deleteById(id);
        return "redirect:/rental_cars";
    }
}
