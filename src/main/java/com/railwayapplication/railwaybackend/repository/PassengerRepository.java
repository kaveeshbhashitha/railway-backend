package com.railwayapplication.railwaybackend.repository;

import com.railwayapplication.railwaybackend.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findByEmailAndPassword(String email, String password);

}

