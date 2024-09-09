package com.carShowRoom.CarShowRoom.Repository;

import com.carShowRoom.CarShowRoom.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByUserId(long userId);

    List<Car> findByNameStartingWith(String str);

    List<Car> findByUserIdAndNameContainingIgnoreCase(long userId,String search);

//    @Query("SELECT c FROM Car c WHERE c.userId = :userId" +
//            " AND (:name IS NULL OR c.name LIKE %:name%)" +
//            " AND (:company IS NULL OR c.company LIKE %:company%)" +
//            " AND (:color IS NULL OR c.color LIKE %:color%)")
//    List<Car> findByUserIdAndCriteria(
//            @Param("userId") long userId,
//            @Param("name") String name,
//            @Param("company") String company,
//            @Param("color") String color
//    );
}

