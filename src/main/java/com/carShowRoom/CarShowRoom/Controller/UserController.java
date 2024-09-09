package com.carShowRoom.CarShowRoom.Controller;

import com.carShowRoom.CarShowRoom.Dto.CarDto;
import com.carShowRoom.CarShowRoom.Dto.UserRegisterationDto;
import com.carShowRoom.CarShowRoom.Entity.Car;
import com.carShowRoom.CarShowRoom.Entity.RentalCars;
import com.carShowRoom.CarShowRoom.Entity.User;
import com.carShowRoom.CarShowRoom.Service.CarService;
import com.carShowRoom.CarShowRoom.Service.RentalService;
import com.carShowRoom.CarShowRoom.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private RentalService rentalService;

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String currentUsername = userDetails.getUsername();
        model.addAttribute("username", currentUsername);
        return "home";
    }


    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        User user = userService.findUserByName(username);
        model.addAttribute("user", user);
        //System.out.println(user.toString());
        return "profile";
    }

    @GetMapping("/profile/image/{userId}")
    @ResponseBody
    public ResponseEntity<byte[]> getUserProfileImage(@PathVariable Long userId) {
        User user = userService.findById(userId);
        byte[] image = user.getImage();

        if (image == null) {
            // Return a default image if the user doesn't have one
            System.out.println("No Image Found");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @GetMapping("/car/image/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getCarProfileImage(@PathVariable("id") int carId) {
        Car car = carService.getCarById(carId);
        byte[] image = car.getImage();

        if (image == null) {
            // Return a default image if the user doesn't have one
            System.out.println("No Image Found");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }


    @GetMapping("/available_cars")
    public ModelAndView getAllCars(@RequestParam(value = "search", required = false) String search, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        User user = userService.findUserByName(username);
        long id = user.getId();

        List<CarDto> list;
        if (search != null && !search.isEmpty()) {
            list = carService.findByUserIdAndNameContainingIgnoreCase(id, search);

        } else {
            list = carService.findByUserId(id);
        }

//        List<CarDto> list = carService.findByUserId(id);
        ModelAndView m = new ModelAndView("carshow");
        m.addObject("cars", list);
        return m;
    }

    @GetMapping("/startwith-A")
    public List<Car> getCarsstartwithA() {
        return carService.getCarsStartWithA();
    }

    @GetMapping("/car_register")
    public String carRegister() {
        return "carRegister";
    }

    @PostMapping("/save")
    public String addCar(@ModelAttribute("CarDto") CarDto carDto, Authentication authentication) {
        // Fetch the authenticated user from the Authentication object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findUserByName(userDetails.getUsername());

        if (user == null) {
            throw new RuntimeException("Authenticated user not found in database.");
        }

        Car car = new Car();
        car.setName(carDto.getName());
        car.setCompany(carDto.getCompany());
        car.setModel(carDto.getModel());
        car.setUser(user);
        car.setColor(carDto.getColor());
        car.setPrice(carDto.getPrice());

        MultipartFile profileImage = carDto.getProfileImage();
        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                car.setImage(profileImage.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the error appropriately
            }
        }

        carService.saveCar(car);

        return "redirect:/available_cars"; // Redirecting to a list page after adding the car
    }

}
