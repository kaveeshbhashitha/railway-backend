package com.railwayapplication.railwaybackend.controllers;

import com.railwayapplication.railwaybackend.exceptions.PassengerNotFoundException;
import com.railwayapplication.railwaybackend.exceptions.ReservationNotFoundException;
import com.railwayapplication.railwaybackend.models.Passenger;
import com.railwayapplication.railwaybackend.models.Reservation;
import com.railwayapplication.railwaybackend.models.Train;
import com.railwayapplication.railwaybackend.repository.ReservationRepository;
import com.railwayapplication.railwaybackend.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/reserve")
public class ReservationControle {
    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping("/register")
    Reservation newUser(@RequestBody Reservation newUser){
        return reservationRepository.save(newUser);
    }
    @GetMapping("/searchAll")
    List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }
    @GetMapping("/search/{id}")
    Reservation getReservationById(@PathVariable Long id){
        return reservationRepository.findById(id).orElseThrow(()->new PassengerNotFoundException(id));
    }
    @DeleteMapping("/delete/{id}")
    String deleteReservation(@PathVariable Long id){
        if(!reservationRepository.existsById(id)){
            throw new ReservationNotFoundException(id);
        }
        reservationRepository.deleteById(id);
        return "Reservation with id "+id+" has been deleted successfully.";
    }
}
//http://localhost:8080/reserve/register