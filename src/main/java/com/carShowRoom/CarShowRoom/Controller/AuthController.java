package com.carShowRoom.CarShowRoom.Controller;

import com.carShowRoom.CarShowRoom.Dto.UserRegisterationDto;
import com.carShowRoom.CarShowRoom.Entity.User;
import com.carShowRoom.CarShowRoom.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterationForm(Model model) {
        model.addAttribute("user", new UserRegisterationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") UserRegisterationDto userRegisterationDto, RedirectAttributes redirectAttributes) {
        // System.out.println(userRegisterationDto.toString());
        userService.save(userRegisterationDto);
        redirectAttributes.addFlashAttribute("message", "Registration successful");
        return "redirect:/login";
    }


}
