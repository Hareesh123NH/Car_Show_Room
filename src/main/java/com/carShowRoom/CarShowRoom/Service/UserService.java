package com.carShowRoom.CarShowRoom.Service;

import com.carShowRoom.CarShowRoom.Dto.UserRegisterationDto;
import com.carShowRoom.CarShowRoom.Entity.User;
import com.carShowRoom.CarShowRoom.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public void save(UserRegisterationDto userRegisterationDto) {

        User user = new User();
        user.setUsername(userRegisterationDto.getUserName());
        user.setPassword(passwordEncoder.encode(userRegisterationDto.getPassword())); // Ensure you handle password encoding
        user.setEmail(userRegisterationDto.getEmail());
        user.setPhone(userRegisterationDto.getPhone());
        user.setAddress(userRegisterationDto.getAddress());

        MultipartFile profileImage = userRegisterationDto.getProfileImage();
        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                user.setImage(profileImage.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the error appropriately
            }
        }
        userRepository.save(user);
    }

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(long id) {
        return userRepository.getReferenceById(id);
    }

}
