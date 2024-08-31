package com.carShowRoom.CarShowRoom.Controller;

import com.carShowRoom.CarShowRoom.Dto.CarDto;
import com.carShowRoom.CarShowRoom.Entity.Car;
import com.carShowRoom.CarShowRoom.Entity.RentalCars;
import com.carShowRoom.CarShowRoom.Entity.User;
import com.carShowRoom.CarShowRoom.Service.CarService;
import com.carShowRoom.CarShowRoom.Service.RentalService;
import com.carShowRoom.CarShowRoom.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;

    @GetMapping("/rental_cars")
    public ModelAndView getRentalCars(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        User user = userService.findUserByName(username);
        long id = user.getId();
        List<RentalCars> list = rentalService.findByUserId(id);
        ModelAndView m = new ModelAndView("rentalCars");
        m.addObject("cars", list);
        return m;
    }

    @RequestMapping("/rental_cars/{id}")
    public String getRentalList(@PathVariable("id") int id) {
        Car car = carService.getCarById(id);
        RentalCars rentalCars = new RentalCars(car.getId(), car.getName(), car.getCompany(), car.getModel(), car.getColor(), car.getPrice(), car.getUser());
        rentalService.saveRental(rentalCars);
        return "redirect:/rental_cars";
    }

    @RequestMapping("/delete_rental/{id}")
    public String deleteById(@PathVariable int id) {
        rentalService.deleteById(id);
        return "redirect:/rental_cars";
    }

    @RequestMapping("/delete_car/{id}")
    public String removeCarById(@PathVariable int id) {
        rentalService.deleteById(id);
        carService.deleteById(id);
        return "redirect:/available_cars";
    }
}
