package com.carShowRoom.CarShowRoom.Repository;

import com.carShowRoom.CarShowRoom.Entity.Car;
import com.carShowRoom.CarShowRoom.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
