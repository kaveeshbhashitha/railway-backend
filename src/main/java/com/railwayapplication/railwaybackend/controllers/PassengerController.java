package com.railwayapplication.railwaybackend.controllers;

import com.railwayapplication.railwaybackend.models.Passenger;
import com.railwayapplication.railwaybackend.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerRepository passengerRepository;

    @PostMapping("/register")
    Passenger newUser(@RequestBody Passenger newUser){
        return passengerRepository.save(newUser);
    }

    @GetMapping("/searchByEmail")
    public List<Passenger> findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return passengerRepository.findByEmailAndPassword(email, password);
    }

}
