package com.carShowRoom.CarShowRoom.Controller;

import com.carShowRoom.CarShowRoom.Entity.Car;
import com.carShowRoom.CarShowRoom.Entity.RentalCars;
import com.carShowRoom.CarShowRoom.Service.CarService;
import com.carShowRoom.CarShowRoom.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/car_register")
    public String carRegister(){
        return "carRegister";
    }

    @GetMapping("/available_cars")
    public ModelAndView getAllCars(){
        List<Car> list=carService.getAllCars();
        ModelAndView m=new ModelAndView("carList");
        m.addObject("cars",list);
        return m;
    }

    @PostMapping("/save")
    public String addCar(@ModelAttribute Car car){
        carService.save(car);
        return "redirect:/available_cars";
    }

    @GetMapping("/rental_cars")
    public ModelAndView getRentalCars(){
        List<RentalCars> list=rentalService.getAllRentalCars();
        ModelAndView m=new ModelAndView("rentalCars");
        m.addObject("cars",list);
        return m;
    }

    @RequestMapping("/rental_cars/{id}")
    public String getRentalList(@PathVariable("id") int id){
        Car car=carService.getCarById(id);
        RentalCars rentalCars=new RentalCars(car.getId(),car.getName(),car.getCompany(),car.getModel(),car.getColor(),car.getPrice());
        rentalService.saveRental(rentalCars);
        return "redirect:/rental_cars";
    }

    @RequestMapping("delete_car/{id}")
    public String deleteById(@PathVariable int id){
        carService.deleteCarById(id);
        rentalService.deleteById(id);
        return "redirect:/available_cars";
    }
}
